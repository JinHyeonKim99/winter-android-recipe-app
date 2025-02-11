//package com.surivalcoding.composerecipeapp.core.di.koin
//
//import com.surivalcoding.composerecipeapp.data.data_source.MockRecipeDataSourceImpl
//import com.surivalcoding.composerecipeapp.data.data_source.MockUserDataSourceImpl
//import com.surivalcoding.composerecipeapp.data.data_source.RecipeDataSource
//import com.surivalcoding.composerecipeapp.data.data_source.UserDataSource
//import org.koin.dsl.module
//
//val dataSourceModule = module {
//    single<RecipeDataSource> {
//        MockRecipeDataSourceImpl()
//    }
//
//    single<UserDataSource> {
//        MockUserDataSourceImpl()
//    }
//}