package com.surivalcoding.composerecipeapp.presentation.main_screen

import com.surivalcoding.composerecipeapp.data.filter.Category
import com.surivalcoding.composerecipeapp.domain.model.Recipe

data class MainScreenState(
    val isFocused: Boolean = true,
    val isLoading: Boolean = false,
    val recipes: List<Recipe> = emptyList(),
    val isBookmarked: Boolean = false,
    val categories: List<Category> = Category.entries,
)