package com.surivalcoding.composerecipeapp.presentation.recipe_detail_screen

import com.surivalcoding.composerecipeapp.domain.model.Ingredient

sealed interface RecipeDetailAction {
        data class OnClickBookmarkButton(val id: Int) : RecipeDetailAction
        data class OnClickIngredientTab(val ingredient: Ingredient) : RecipeDetailAction
        data class OnClickProcedureTab(val procedure: String) : RecipeDetailAction
        data object OnClickFollowButton : RecipeDetailAction
    }
