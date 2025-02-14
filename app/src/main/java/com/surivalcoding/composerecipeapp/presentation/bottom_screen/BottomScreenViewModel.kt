package com.surivalcoding.composerecipeapp.presentation.bottom_screen

import androidx.lifecycle.ViewModel
import com.surivalcoding.composerecipeapp.domain.use_case.GetSearchRecipesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class BottomScreenViewModel @Inject constructor(
    private val getSearchRecipesUseCase: GetSearchRecipesUseCase,
) : ViewModel() {
    private val _state: MutableStateFlow<BottomScreenState> = MutableStateFlow(BottomScreenState())
    val state = _state.asStateFlow()

}