//package com.surivalcoding.composerecipeapp.core.di.koin
//
//import com.surivalcoding.composerecipeapp.domain.usecase.GetBookmarkUseCase
//import com.surivalcoding.composerecipeapp.domain.usecase.GetSavedRecipesUseCase
//import com.surivalcoding.composerecipeapp.presentation.saved_recipes_screen.SavedRecipeViewModel
//import org.koin.core.module.dsl.viewModel
//import org.koin.dsl.module
//
//val appModule = module {
////    single<GetSavedRecipesUseCase> {
////        GetSavedRecipesUseCase(
////            recipeRepository = get(),
////            bookmarkUseCase = get()
////        )
////    }
//
////    single<GetBookmarkUseCase> {
////        GetBookmarkUseCase(
////            bookmarkRepository = get()
////        )
////    }
////
////    viewModel {
////        SavedRecipeViewModel(
////            getSavedRecipesUseCase = get()
////        )
////    }
//
//    // 이렇게도 가능, 여러개 get() 해야할 때 무지성으로 찍어줌 (매직)
////    viewModelOf(::SavedRecipeViewModel)
//
////    viewModel {
////        SearchRecipeViewModel(
////            getSearchRecipesUseCase = get()
////        )
////    }
//}