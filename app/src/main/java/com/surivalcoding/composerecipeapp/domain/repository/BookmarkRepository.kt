package com.surivalcoding.composerecipeapp.domain.repository

interface BookmarkRepository {
    suspend fun getAllBookmarkIds(): List<Int>

    suspend fun cancelBookmarkId(id: Int) : List<Int>

    suspend fun addBookmarkId(id: Int) : List<Int>
}