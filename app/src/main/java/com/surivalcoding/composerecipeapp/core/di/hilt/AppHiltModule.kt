package com.surivalcoding.composerecipeapp.core.di.hilt

import com.surivalcoding.composerecipeapp.data.data_source.MockProdRecipeDataSourceImpl
import com.surivalcoding.composerecipeapp.data.data_source.RecipeDataSource
import com.surivalcoding.composerecipeapp.data.filter.Category
import com.surivalcoding.composerecipeapp.data.filter.FilterType
import com.surivalcoding.composerecipeapp.data.filter.Rate
import com.surivalcoding.composerecipeapp.data.filter.Time
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppHiltModule {

    @Singleton
    @Binds
    abstract fun provideTime(time: Time): FilterType

    @Singleton
    @Binds
    abstract fun provideRate(rate: Rate): FilterType

    @Singleton
    @Binds
    abstract fun provideCategory(category: Category): FilterType
}