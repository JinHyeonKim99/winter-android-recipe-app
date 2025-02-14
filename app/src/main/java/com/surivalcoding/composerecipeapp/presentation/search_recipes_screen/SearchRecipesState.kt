package com.surivalcoding.composerecipeapp.presentation.search_recipes_screen

import com.surivalcoding.composerecipeapp.presentation.filter_enum.Category
import com.surivalcoding.composerecipeapp.presentation.filter_enum.FilterType
import com.surivalcoding.composerecipeapp.presentation.filter_enum.Rate
import com.surivalcoding.composerecipeapp.presentation.filter_enum.Time
import com.surivalcoding.composerecipeapp.domain.model.Recipe

data class SearchRecipesState(
    val recipes: List<Recipe> = emptyList(),
    val query: String = "",
    val isSearching: Boolean = false,
    val searchScreenText: String = "Recent Search",
    val searchResultCount: Int = 0,
    val isLoading: Boolean = false,
    val isFiltering : Boolean = false,
    val onFilterTabSelected: (FilterType) -> Unit = {},
    val isTimeSelected: Boolean = false,
    val isRateSelected: Boolean = false,
    val isCategorySelected: Boolean = false,
    val selectedTimeTab: FilterType = Time.ALL,
    val selectedRateTab: FilterType = Rate.ALL,
    val selectedCategoryTab: FilterType = Category.ALL,
    val showBottomSheet: Boolean = false,
    val timeFilterList: List<FilterType> = Time.entries,
    val rateFilterList: List<FilterType> = Rate.entries.subList(1, Rate.entries.size),
    val categoryFilterList: List<FilterType> = Category.entries,
)