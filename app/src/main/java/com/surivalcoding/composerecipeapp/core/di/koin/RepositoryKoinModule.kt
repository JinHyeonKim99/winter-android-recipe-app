//package com.surivalcoding.composerecipeapp.core.di.koin
//
//import com.surivalcoding.composerecipeapp.data.repository.BookmarkRepositoryImpl
//import com.surivalcoding.composerecipeapp.data.repository.RecipeRepositoryImpl
//import com.surivalcoding.composerecipeapp.domain.repository.BookmarkRepository
//import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository
//import org.koin.dsl.module
//
//val repositoryModule = module {
//    single<RecipeRepository> {
//        RecipeRepositoryImpl(
//            dataSource = get()
//        )
//    }
//
//    single<BookmarkRepository> {
//        BookmarkRepositoryImpl(
//            dataSource = get()
//        )
//    }
//}