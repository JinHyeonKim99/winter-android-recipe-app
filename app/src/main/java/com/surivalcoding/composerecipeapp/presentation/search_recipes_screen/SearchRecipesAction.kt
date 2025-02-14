package com.surivalcoding.composerecipeapp.presentation.search_recipes_screen

import com.surivalcoding.composerecipeapp.presentation.filter_enum.FilterType

sealed interface SearchRecipesAction {
    data class InputQueryChange(val query: String) : SearchRecipesAction
    data object OnClickFilterIconButton : SearchRecipesAction
    data class OnTimeFilterTabSelected(val filterType: FilterType) : SearchRecipesAction
    data class OnRateFilterTabSelected(val filterType: FilterType) : SearchRecipesAction
    data class OnCategoryFilterTabSelected(val filterType: FilterType) : SearchRecipesAction
    data object OnClickFilterButton : SearchRecipesAction
}