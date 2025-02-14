package com.surivalcoding.composerecipeapp.presentation.saved_recipes_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.surivalcoding.composerecipeapp.domain.use_case.GetSavedRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedRecipeViewModel @Inject constructor(
    private val getSavedRecipesUseCase: GetSavedRecipesUseCase,
) : ViewModel() {

    private val _state: MutableStateFlow<SavedRecipeState> = MutableStateFlow(SavedRecipeState())
    val state = _state.asStateFlow()

    init {
        fetchSavedRecipes()
    }

    fun onAction(action: SavedRecipesAction) {
        when (action) {
            is SavedRecipesAction.OnClickBookmarkButton -> {
                onBookmarkClick(action.id)
            }

            is SavedRecipesAction.OnClickRecipeCard -> {}
        }
    }

    private fun onBookmarkClick(id: Int) {
        viewModelScope.launch {
            val recipes = getSavedRecipesUseCase.execute(id)

            _state.update {
                it.copy(
                    savedRecipes = recipes
                )
            }
        }
    }

    private fun fetchSavedRecipes() {
        viewModelScope.launch {
            // 로딩 시작
            _state.update { it.copy(isLoading = true) }

            // Repository에서 데이터를 가져오기
            val recipes = getSavedRecipesUseCase.execute()


            // 로딩 종료 및 상태 업데이트
            _state.update {
                it.copy(
                    isLoading = false,
                    savedRecipes = recipes
                )
            }
        }
    }
}