package com.surivalcoding.composerecipeapp.presentation.main_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.surivalcoding.composerecipeapp.core.util.Result
import com.surivalcoding.composerecipeapp.presentation.Category
import com.surivalcoding.composerecipeapp.domain.use_case.GetBookmarkUseCase
import com.surivalcoding.composerecipeapp.domain.use_case.GetMainScreenRecipesUseCase
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getMainScreenRecipesUseCase: GetMainScreenRecipesUseCase,
    private val getBookmarkUseCase: GetBookmarkUseCase,
) : ViewModel() {
    private val _state: MutableStateFlow<MainScreenState> = MutableStateFlow(MainScreenState())
    val state = _state.asStateFlow()

//    private val _event = MutableSharedFlow<MainScreenEvent>()
//    val event = _event.asSharedFlow()
    private val _event = Channel<MainScreenEvent>()
    val event = _event.receiveAsFlow()

    private var initialRecipes: List<Recipe> = emptyList()  // 초기 리스트 저장
    private var filteredRecipes: List<Recipe> = emptyList() // 필터 적용된 리스트

    init {
        fetchRecipes()
    }

    fun onAction(action: MainAction) {
        when (action) {
            is MainAction.OnClickBookmarkButton -> {
                onBookmarkClick(action.id)
            }

            is MainAction.OnClickCategoryTab -> {
                onCategoryFilterTabSelected(action.category)
            }

            else -> {}
        }
    }

    private fun fetchRecipes() {
        viewModelScope.launch {
            // 로딩 시작
            _state.update { it.copy(isLoading = true) }

            when (val result = getMainScreenRecipesUseCase.execute()) {
                is Result.Error -> {
                    println(result.message)
//                    _event.emit(MainScreenEvent.ShowSnackbar(result.message.toString()))
                    _event.send(MainScreenEvent.ShowSnackbar(result.message.toString()))
                }

                is Result.Success -> {
                    initialRecipes = result.data
                    filteredRecipes = result.data

                    // 로딩 종료 및 상태 업데이트
                    _state.update {
                        it.copy(
                            isLoading = false,
                            recipes = result.data
                        )
                    }

                    onBookmarkCheck()
                }
            }
        }
    }

    private fun onBookmarkCheck() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    bookmarkList = getBookmarkUseCase.execute()
                )
            }
        }
    }

    private fun onBookmarkClick(id: Int) {
        viewModelScope.launch {
            val isAdd = id !in _state.value.bookmarkList

            _state.update {
                it.copy(
                    bookmarkList = getBookmarkUseCase.execute(id, isAdd)
                )
            }
        }
    }

    private fun onCategoryFilterTabSelected(category: Category) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    selectedCategory = category
                )
            }

            val categoryIsAll = _state.value.selectedCategory == Category.ALL

            // 초기 상태 or 필터 All 변경 시 원래 상태로 복구
            if (categoryIsAll) {
                filteredRecipes = initialRecipes
            } else {
                // 필터 적용
                filteredRecipes = initialRecipes.filter { recipe ->
                    recipe.category == _state.value.selectedCategory.displayName
                }
            }

            _state.update {
                it.copy(
                    recipes = filteredRecipes,
                )
            }
        }
    }
}