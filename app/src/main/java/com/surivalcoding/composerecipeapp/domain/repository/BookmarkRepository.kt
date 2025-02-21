package com.surivalcoding.composerecipeapp.domain.repository

interface BookmarkRepository {
    suspend fun getAllBookmarkIds(userId: Int = 1): List<Int>

    suspend fun cancelBookmarkId(recipeId: Int) : List<Int>

    suspend fun addBookmarkId(recipeId: Int) : List<Int>
}