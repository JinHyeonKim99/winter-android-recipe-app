package com.surivalcoding.composerecipeapp.presentation.search_recipes_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.surivalcoding.composerecipeapp.data.filter.Category
import com.surivalcoding.composerecipeapp.data.filter.FilterType
import com.surivalcoding.composerecipeapp.data.filter.Rate
import com.surivalcoding.composerecipeapp.data.filter.Time
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.domain.usecase.GetSearchRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchRecipesViewModel @Inject constructor(
    private val getSearchRecipesUseCase: GetSearchRecipesUseCase,
) : ViewModel() {
    private val _state: MutableStateFlow<SearchRecipesState> =
        MutableStateFlow(SearchRecipesState())
    val state = _state.asStateFlow()

    private var initialRecipes: List<Recipe> = emptyList()  // 초기 리스트 저장
    private var filteredRecipes: List<Recipe> = emptyList() // 필터 적용된 리스트
    private var searchedRecipes: List<Recipe> = emptyList() // 검색 결과 리스트

    init {
        fetchRecipes()
    }

    private fun fetchRecipes() {
        viewModelScope.launch {
            val recipes = getSearchRecipesUseCase.execute()
            initialRecipes = recipes
            filteredRecipes = recipes
            searchedRecipes = recipes
            _state.emit(SearchRecipesState(recipes = recipes))
        }
    }

    fun onAction(action: SearchRecipesAction) {
        when (action) {
            is SearchRecipesAction.InputQueryChange -> {
                onSearchQueryChanged(action.query)
            }

            SearchRecipesAction.OnClickFilterIconButton -> {
                onFilterIconButtonClicked()
            }

            is SearchRecipesAction.OnTimeFilterTabSelected -> {
                onTimeFilterTabSelected(action.filterType)
            }

            is SearchRecipesAction.OnRateFilterTabSelected -> {
                onRateFilterTabSelected(action.filterType)
            }

            is SearchRecipesAction.OnCategoryFilterTabSelected -> {
                onCategoryFilterTabSelected(action.filterType)
            }

            SearchRecipesAction.OnClickFilterButton -> {
                onFilterButtonClicked()
            }
        }
    }

    private fun onSearchQueryChanged(newQuery: String) {
        viewModelScope.launch {
            _state.update {
                it.copy(query = newQuery, isSearching = true)
            }
            performSearch(newQuery)
        }
    }

    private fun performSearch(query: String) {
        viewModelScope.launch {
            searchedRecipes = if (query.isEmpty()) {
                _state.update {
                    it.copy(isSearching = false)
                }
                if (_state.value.isFiltering) {
                    filteredRecipes  // 필터 유지한 채 검색 초기화
                } else {
                    initialRecipes  // 원본 리스트 복원
                }
            } else {
                filteredRecipes.filter { it.title.contains(query, ignoreCase = true) }
            }

            _state.update {
                it.copy(
                    recipes = searchedRecipes,
                    searchResultCount = searchedRecipes.size,
                    searchScreenText = if (_state.value.isSearching || _state.value.isFiltering) "Search Result" else "Recent Search",
                )
            }
        }
    }

    private fun onFilterIconButtonClicked() {
        viewModelScope.launch {
            _state.update { it.copy(showBottomSheet = !_state.value.showBottomSheet) }
        }
    }

    private fun onFilterButtonClicked() {
        viewModelScope.launch {
            val categoryIsAll = _state.value.selectedCategoryTab == Category.ALL
            val rateIsAll = _state.value.selectedRateTab == Rate.ALL
            val timeIsAll = _state.value.selectedTimeTab == Time.ALL

            // 필터 적용
            filteredRecipes = initialRecipes.filter { recipe ->
                val matchesCategory =
                    categoryIsAll || recipe.category == _state.value.selectedCategoryTab.displayName
                val matchesRate =
                    rateIsAll || recipe.starRate >= _state.value.selectedRateTab.displayName.toDouble()
                matchesCategory && matchesRate
            }

            filteredRecipes = when (_state.value.selectedTimeTab) {
                Time.NEWEST -> filteredRecipes.sortedByDescending { it.createdAt }
                Time.OLDEST -> filteredRecipes.sortedBy { it.createdAt }
                else -> filteredRecipes
            }

            // 필터 해제 시 원래 상태로 복구
            if (timeIsAll && rateIsAll && categoryIsAll) {
                filteredRecipes = initialRecipes
                _state.update { it.copy(isFiltering = false) }
            } else {
                _state.update { it.copy(isFiltering = true) }
            }

            // 필터 후 검색 상태 반영
            searchedRecipes = if (_state.value.query.isEmpty()) {
                filteredRecipes
            } else {
                filteredRecipes.filter { it.title.contains(_state.value.query, ignoreCase = true) }
            }

            _state.update {
                it.copy(
                    recipes = searchedRecipes,
                    searchResultCount = searchedRecipes.size,
                    showBottomSheet = false,
                    searchScreenText = if (_state.value.isSearching || _state.value.isFiltering) "Search Result" else "Recent Search",
                )
            }
        }
    }

    private fun onTimeFilterTabSelected(filterTab: FilterType) {
        viewModelScope.launch {
            _state.update { it.copy(selectedTimeTab = filterTab) }
        }
    }

    private fun onRateFilterTabSelected(filterTab: FilterType) {
        viewModelScope.launch {
            val currentRateTab = _state.value.selectedRateTab
            _state.update {
                it.copy(
                    selectedRateTab = if (currentRateTab == filterTab) Rate.ALL else filterTab
                )
            }
        }
    }

    private fun onCategoryFilterTabSelected(filterTab: FilterType) {
        viewModelScope.launch {
            _state.update { it.copy(selectedCategoryTab = filterTab) }
        }
    }
}