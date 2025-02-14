package com.surivalcoding.composerecipeapp.core.di.hilt

import com.surivalcoding.composerecipeapp.presentation.filter_enum.Category
import com.surivalcoding.composerecipeapp.presentation.filter_enum.FilterType
import com.surivalcoding.composerecipeapp.presentation.filter_enum.Rate
import com.surivalcoding.composerecipeapp.presentation.filter_enum.Time
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