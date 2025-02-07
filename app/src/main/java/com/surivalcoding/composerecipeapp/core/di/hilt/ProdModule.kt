package com.surivalcoding.composerecipeapp.core.di.hilt

import com.surivalcoding.composerecipeapp.data.data_source.MockProdRecipeDataSourceImpl
import com.surivalcoding.composerecipeapp.data.data_source.RecipeDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ProdModule {

    @Singleton
    @Binds
    abstract fun provideRecipeDataSource(recipeDataSourceImpl: MockProdRecipeDataSourceImpl): RecipeDataSource
}