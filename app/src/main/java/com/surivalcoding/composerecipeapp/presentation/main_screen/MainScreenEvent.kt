package com.surivalcoding.composerecipeapp.presentation.main_screen

sealed interface MainScreenEvent {
    data class ShowSnackbar(val message: String) : MainScreenEvent
    data class ShowDialog(val message: String) : MainScreenEvent
}