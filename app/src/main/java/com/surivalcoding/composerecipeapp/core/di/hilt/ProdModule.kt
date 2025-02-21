package com.surivalcoding.composerecipeapp.core.di.hilt

import com.surivalcoding.composerecipeapp.data.remote.data_source.MockProdRecipeDataSourceImpl
import com.surivalcoding.composerecipeapp.data.remote.data_source.RecipeDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//abstract class ProdModule {
//
//    @Singleton
//    @Binds
//    abstract fun bindRecipeDataSource(
//        recipeDataSourceImpl: MockProdRecipeDataSourceImpl,
//    ): RecipeDataSource
//}