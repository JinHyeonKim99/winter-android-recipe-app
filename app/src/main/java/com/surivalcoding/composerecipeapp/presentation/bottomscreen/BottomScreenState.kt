package com.surivalcoding.composerecipeapp.presentation.bottomscreen

data class BottomScreenState(
    val isMainFocused: Boolean = false,
    val isSavedRecipeFocused: Boolean = false,
    val isThirdFocused: Boolean = false,
    val isFourthFocused: Boolean = false,
)