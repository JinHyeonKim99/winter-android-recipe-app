package com.surivalcoding.composerecipeapp.presentation.main_screen

import com.surivalcoding.composerecipeapp.presentation.filter_enum.Category

sealed interface MainAction {
    data class OnClickCategoryTab(val category: Category) : MainAction
    data class OnClickBookmarkButton(val id: Int) : MainAction
    data object OnClickSearchField : MainAction
    data object OnClickRecipeCard : MainAction
}