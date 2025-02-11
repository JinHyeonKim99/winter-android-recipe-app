package com.surivalcoding.composerecipeapp.presentation.saved_recipes_screen

import com.surivalcoding.composerecipeapp.domain.model.Recipe

data class SavedRecipeState(
    val savedRecipes: List<Recipe> = emptyList(),
    val isLoading: Boolean = false,
    val isBookmark: Boolean = true,
)