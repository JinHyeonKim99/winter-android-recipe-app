package com.surivalcoding.composerecipeapp.presentation.saved_recipes_screen

import com.surivalcoding.composerecipeapp.domain.model.Recipe

sealed interface SavedRecipesAction {
    data class OnClickBookmarkButton(val id: Int) : SavedRecipesAction
    data class OnClickRecipeCard(val recipe: Recipe) : SavedRecipesAction
}