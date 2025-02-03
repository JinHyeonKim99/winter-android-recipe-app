package com.surivalcoding.composerecipeapp.presentation.bottomscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.surivalcoding.composerecipeapp.domain.GetSearchRecipesUseCase
import com.surivalcoding.composerecipeapp.presentation.search_recipes_screen.SearchRecipeState
import com.surivalcoding.composerecipeapp.presentation.search_recipes_screen.SearchRecipeViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BottomScreenViewModel @Inject constructor(
    private val getSearchRecipesUseCase: GetSearchRecipesUseCase,
) : ViewModel() {
    private val _state: MutableStateFlow<BottomScreenState> = MutableStateFlow(BottomScreenState())
    val state = _state.asStateFlow()

}