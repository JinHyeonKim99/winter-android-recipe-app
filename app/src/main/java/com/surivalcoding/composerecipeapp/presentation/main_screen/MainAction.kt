package com.surivalcoding.composerecipeapp.presentation.main_screen

import com.surivalcoding.composerecipeapp.data.filter.Category

sealed interface MainAction {
    data object OnClickSearchField : MainAction
    data class OnClickCategoryTab(val category: Category) : MainAction
    data object OnClickRecipeCard : MainAction
    data class OnClickBookmarkButton(val id: Int) : MainAction
}