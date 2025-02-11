package com.surivalcoding.composerecipeapp.presentation.main_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun MainScreenRoot(
    onSearchFieldClick: () -> Unit = {},
    onRecipeCardClick: () -> Unit = {},
) {
    val viewModel: MainScreenViewModel = hiltViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    MainScreen(
        state = state,
        onAction = { action ->
            when (action) {
                is MainAction.OnClickBookmarkButton -> {
                    viewModel.onAction(MainAction.OnClickBookmarkButton(action.id))
                }

                is MainAction.OnClickCategoryTab -> {
                    viewModel.onAction(MainAction.OnClickCategoryTab(action.category))
                }

                MainAction.OnClickSearchField -> onSearchFieldClick()
                MainAction.OnClickRecipeCard -> onRecipeCardClick()
            }
        }
    )
}