package com.surivalcoding.composerecipeapp.presentation.search_recipes_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.surivalcoding.composerecipeapp.data.filter.FilterType
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.domain.GetSearchRecipesUseCase
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

    init {
        fetchRecipes()
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

    //val isSelected = filterType == selectedFilterTab
    private fun fetchRecipes() {
        viewModelScope.launch {
            _state.emit(
                SearchRecipesState(
                    recipes = getSearchRecipesUseCase.execute(),
                    selectedTimeTab = _state.value.selectedTimeTab,
                    selectedCategoryTab = _state.value.selectedCategoryTab,
                    timeFilterList = _state.value.timeFilterList,
                    rateFilterList = _state.value.rateFilterList,
                    categoryFilterList = _state.value.categoryFilterList,
                    isTimeSelected = _state.value.isTimeSelected,
                    isRateSelected = _state.value.isRateSelected,
                    isCategorySelected = _state.value.isCategorySelected,

                )
            )
        }
    }

    // 검색 결과 리스트
    private var recipes = MutableStateFlow(listOf<Recipe>())

    private var screenText = MutableStateFlow<String>("Recent Search")
    private var isSearching = MutableStateFlow<Boolean>(false)

    // 검색어 변경 처리
    private fun onSearchQueryChanged(newQuery: String) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    query = newQuery,
                    searchScreenText = "Search Result",
                    isSearching = isSearching.value,
                )
            }

            val allRecipes = getSearchRecipesUseCase.execute()

            performSearch(newQuery, allRecipes)

            _state.update {
                it.copy(
                    recipes = recipes.value,
                    searchScreenText = screenText.value,
                    searchResultCount = recipes.value.size,
                    isSearching = isSearching.value
                )
            }
        }
    }

    // 검색 수행 로직
    private fun performSearch(query: String, allRecipes: List<Recipe>) {
        if (query.isEmpty()) {
            recipes.value = allRecipes
            screenText.value = "Recent Search"
            isSearching.value = false
        } else {
            recipes.value = allRecipes.filter { it.title.contains(query, ignoreCase = true) }
            screenText.value = "Search Result"
            isSearching.value = true
        }
    }

    private fun onFilterIconButtonClicked() {
        viewModelScope.launch {
            println("필터 아이콘")
            _state.update {
                it.copy(
                    showBottomSheet = !_state.value.showBottomSheet,
                )
            }
        }
    }

    private fun onFilterButtonClicked() {
        viewModelScope.launch {
            println("필터 버튼")
            _state.update {
                it.copy(
                    showBottomSheet = !_state.value.showBottomSheet,
                )
            }
        }
    }

    private fun onTimeFilterTabSelected(filterTab: FilterType) {
        viewModelScope.launch {
            println("time 필터 탭")
            println(filterTab)
            println(_state.value.selectedTimeTab)
            _state.update {
                it.copy(
                    selectedTimeTab = filterTab,
                )
            }
            println(_state.value.selectedTimeTab)
        }
    }

    private fun onRateFilterTabSelected(filterTab: FilterType) {
        viewModelScope.launch {
            println("Rate 필터 탭")
            println(filterTab)
            println(_state.value.selectedTimeTab)
            println(_state.value.selectedRateTab)
            println(_state.value.selectedCategoryTab)
            println(_state.value.isRateSelected)
            _state.update {
                it.copy(
                    selectedRateTab = filterTab,
                    isRateSelected = !_state.value.isRateSelected,
                )
            }
            println(_state.value.selectedTimeTab)
            println(_state.value.selectedRateTab)
            println(_state.value.selectedCategoryTab)
            println(_state.value.isRateSelected)
        }
    }

    private fun onCategoryFilterTabSelected(filterTab: FilterType) {
        viewModelScope.launch {
            println("Category 필터 탭")
            println(filterTab)
            println(_state.value.selectedCategoryTab)
            _state.update {
                it.copy(
                    selectedCategoryTab = filterTab,
                )
            }
            println(_state.value.selectedCategoryTab)
        }
    }
}