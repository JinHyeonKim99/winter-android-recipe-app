package com.surivalcoding.composerecipeapp.presentation.main_screen

import com.surivalcoding.composerecipeapp.presentation.filter_enum.Category
import com.surivalcoding.composerecipeapp.domain.model.Recipe

data class MainScreenState(
    val isFocused: Boolean = true,
    val isLoading: Boolean = false,
    val recipes: List<Recipe> = emptyList(),
    val categories: List<Category> = Category.entries,
    val selectedCategory: Category = Category.ALL,
    val bookmarkList: List<Int> = emptyList(),
)