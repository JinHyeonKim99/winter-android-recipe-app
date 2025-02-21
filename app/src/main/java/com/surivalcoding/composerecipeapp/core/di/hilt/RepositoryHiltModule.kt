package com.surivalcoding.composerecipeapp.core.di.hilt

import com.surivalcoding.composerecipeapp.data.remote.repository.BookmarkRepositoryImpl
import com.surivalcoding.composerecipeapp.data.remote.repository.MockNetworkErrorRecipeRepositoryImpl
import com.surivalcoding.composerecipeapp.data.remote.repository.RecipeRepositoryImpl
import com.surivalcoding.composerecipeapp.domain.repository.BookmarkRepository
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryHiltModule {

    @Singleton
    @Binds
    abstract fun bindRecipeRepository(recipeRepository: RecipeRepositoryImpl): RecipeRepository

//    @Singleton
//    @Binds
//    abstract fun provideRecipeRepository(recipeRepository: MockNetworkErrorRecipeRepositoryImpl): RecipeRepository

    @Singleton
    @Binds
    abstract fun bindBookmarkRepository(bookmarkRepository: BookmarkRepositoryImpl): BookmarkRepository
}