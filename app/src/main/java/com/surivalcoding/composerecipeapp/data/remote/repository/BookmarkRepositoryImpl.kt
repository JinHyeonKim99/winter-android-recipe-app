package com.surivalcoding.composerecipeapp.data.remote.repository

import com.surivalcoding.composerecipeapp.data.remote.data_source.UserDataSource
import com.surivalcoding.composerecipeapp.data.remote.mapper.toUser
import com.surivalcoding.composerecipeapp.domain.repository.BookmarkRepository
import javax.inject.Inject

class BookmarkRepositoryImpl @Inject constructor(
    private val dataSource: UserDataSource,
) : BookmarkRepository {
    // mock 데이터라서 사용한 변수들
    private var bookmarkList = mutableListOf<Int>()
    private var isStarted = true

    override suspend fun getAllBookmarkIds(userId: Int): List<Int> {
        if (isStarted) {
            isStarted = false
            bookmarkList = dataSource.getUserById(userId).map {
                it.toUser()
            }[0].savedRecipesId.toMutableList()
        } else {
            bookmarkList
        }

        return bookmarkList.toList()
    }

    override suspend fun cancelBookmarkId(recipeId: Int): List<Int> {
        bookmarkList.remove(recipeId)
        return bookmarkList.toList()
    }

    override suspend fun addBookmarkId(recipeId: Int): List<Int> {
        bookmarkList.add(recipeId)
        return bookmarkList.toList()
    }
}