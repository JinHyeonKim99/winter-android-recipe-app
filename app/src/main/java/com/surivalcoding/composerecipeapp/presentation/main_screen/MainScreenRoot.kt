package com.surivalcoding.composerecipeapp.presentation.main_screen

import android.widget.Toast
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun MainScreenRoot(
    onSearchFieldClick: () -> Unit = {},
    onRecipeCardClick: () -> Unit = {},
) {
    val viewModel: MainScreenViewModel = hiltViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    val snackbarHostState = remember { SnackbarHostState() }

    val context = LocalContext.current

    LaunchedEffect(viewModel) {
        viewModel.event.collect { event ->
            when (event) {
                is MainScreenEvent.ShowSnackbar -> {
                    Toast.makeText(context, event.message, Toast.LENGTH_SHORT).show()
                    snackbarHostState.showSnackbar(
                        message = event.message,
                        duration = SnackbarDuration.Short,
                    )
                }

                is MainScreenEvent.ShowDialog -> {

                }
            }
        }
    }


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