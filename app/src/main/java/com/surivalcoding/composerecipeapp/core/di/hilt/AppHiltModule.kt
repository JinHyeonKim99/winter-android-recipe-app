package com.surivalcoding.composerecipeapp.core.di.hilt

import com.surivalcoding.composerecipeapp.domain.CancelBookmarkUseCase
import com.surivalcoding.composerecipeapp.domain.GetSavedRecipesUseCase
import com.surivalcoding.composerecipeapp.domain.model.Category
import com.surivalcoding.composerecipeapp.domain.repository.BookmarkRepository
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppHiltModule {

//    @Singleton
//    @Provides
//    fun provideCategory(category: Category): Category {
//        return Category.ALL
//    }
//
//    @Singleton
//    @Provides
//    fun provideCancelBookmarkUseCase(bookmarkRepository: BookmarkRepository): CancelBookmarkUseCase {
//        return CancelBookmarkUseCase(
//            bookmarkRepository = bookmarkRepository
//        )
//    }
}