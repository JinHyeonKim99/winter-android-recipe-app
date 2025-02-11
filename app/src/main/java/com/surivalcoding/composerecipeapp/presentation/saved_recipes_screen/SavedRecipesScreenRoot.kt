package com.surivalcoding.composerecipeapp.presentation.saved_recipes_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun SavedRecipesScreenRoot(
    onClickRecipeButton: () -> Unit = {},
) {
    val viewModel: SavedRecipeViewModel = hiltViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    SavedRecipesScreen(
        state = state,
        onAction = { action ->
            when (action) {
                is SavedRecipesAction.OnClickBookmarkButton -> {
                    viewModel.onAction(SavedRecipesAction.OnClickBookmarkButton(action.id))
                }
                is SavedRecipesAction.OnClickRecipeCard -> {
                    onClickRecipeButton()
                }
            }
        }
    )
}