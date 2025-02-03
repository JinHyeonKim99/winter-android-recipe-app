package com.surivalcoding.composerecipeapp.presentation.search_recipes_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.domain.GetSearchRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchRecipeViewModel @Inject constructor(
    private val getSearchRecipesUseCase: GetSearchRecipesUseCase,
) : ViewModel() {
//    private val _savedRecipes: MutableStateFlow<List<Recipe>> = MutableStateFlow(emptyList())
//    val savedRecipes = _savedRecipes.asStateFlow()

    private val _state: MutableStateFlow<SearchRecipeState> = MutableStateFlow(SearchRecipeState())
    val state = _state.asStateFlow()

    init {
        fetchRecipes()
    }

    private fun fetchRecipes() {
        viewModelScope.launch {
            _state.emit(
                SearchRecipeState(
                    recipes = getSearchRecipesUseCase.execute()
                )
            )
        }
    }

    // 검색 결과 리스트
    private var recipes = MutableStateFlow(listOf<Recipe>())
    private var screenText = MutableStateFlow<String>("Recent Search")
    private var isSearching = MutableStateFlow<Boolean>(false)

    // 검색어 변경 처리
    fun onSearchQueryChanged(newQuery: String) {
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

    fun searchRecipes(query: String) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            val recipes = getSearchRecipesUseCase.execute()

            _state.update {
                it.copy(
                    isLoading = false,
                    recipes = recipes
                )
            }
        }
    }

    fun waitSearchRecipes() {
        viewModelScope.launch {
            // 로딩 시작
            _state.update { it.copy(isLoading = true) }

            // Repository에서 데이터를 가져오기
            val recipes = getSearchRecipesUseCase.execute()

            // 로딩 종료 및 상태 업데이트
            _state.update {
                it.copy(
                    isLoading = false,
                    recipes = recipes
                )
            }
        }
    }
}