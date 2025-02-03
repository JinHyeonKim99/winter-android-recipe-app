package com.surivalcoding.composerecipeapp.presentation.mainscreen

import androidx.lifecycle.ViewModel
import com.surivalcoding.composerecipeapp.domain.CancelBookmarkUseCase
import com.surivalcoding.composerecipeapp.domain.GetSavedRecipesUseCase
import com.surivalcoding.composerecipeapp.domain.model.Category
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getSavedRecipesUseCase: GetSavedRecipesUseCase,
    private val cancelBookmarkUseCase: CancelBookmarkUseCase,
    private val category: Category,
) : ViewModel() {

}