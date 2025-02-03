package com.surivalcoding.composerecipeapp.presentation.mainscreen

import com.surivalcoding.composerecipeapp.domain.model.Recipe

data class MainScreenState(
    val isFocused: Boolean = true,
    val isLoading: Boolean = false,
    val recipes: List<Recipe> = emptyList(),
)