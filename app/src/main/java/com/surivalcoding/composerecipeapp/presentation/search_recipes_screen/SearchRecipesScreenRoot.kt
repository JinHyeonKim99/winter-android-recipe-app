package com.surivalcoding.composerecipeapp.presentation.search_recipes_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun SearchRecipesScreenRoot(
    // 네비게이션 루트로 전해줄 콜백을 여기에
    // view model에 보내야하는 콜백은 밑에서
) {
    val viewModel: SearchRecipesViewModel = hiltViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    SearchRecipesScreen(
        state = state,
        onAction = { action ->
            when (action) {
                is SearchRecipesAction.InputQueryChange -> {
                    viewModel.onAction(SearchRecipesAction.InputQueryChange(action.query))
                }
                SearchRecipesAction.OnClickFilterButton -> {
                    viewModel.onAction(SearchRecipesAction.OnClickFilterButton)
                }
                SearchRecipesAction.OnClickFilterIconButton -> {
                    viewModel.onAction(SearchRecipesAction.OnClickFilterIconButton)
                }
                is SearchRecipesAction.OnTimeFilterTabSelected -> {
                    viewModel.onAction(SearchRecipesAction.OnTimeFilterTabSelected(action.filterType))
                }
                is SearchRecipesAction.OnRateFilterTabSelected -> {
                    viewModel.onAction(SearchRecipesAction.OnRateFilterTabSelected(action.filterType))
                }
                is SearchRecipesAction.OnCategoryFilterTabSelected -> {
                    viewModel.onAction(SearchRecipesAction.OnCategoryFilterTabSelected(action.filterType))
                }
            }
        },
    )
}