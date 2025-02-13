package com.surivalcoding.composerecipeapp.data.repository

import com.surivalcoding.composerecipeapp.data.data_source.UserDataSource
import com.surivalcoding.composerecipeapp.data.mapper.toUser
import com.surivalcoding.composerecipeapp.domain.repository.BookmarkRepository
import javax.inject.Inject

class BookmarkRepositoryImpl @Inject constructor(
    private val dataSource: UserDataSource,
) : BookmarkRepository {
    // mock 데이터라서 사용한 변수들
    private var bookmarkList = mutableListOf<Int>()
    private var isStarted = true

    override suspend fun getAllBookmarkIds(): List<Int> {
        if (isStarted) {
            isStarted = false
            bookmarkList = dataSource.getAllUsers().map {
                it.toUser()
            }[0].savedRecipesId.toMutableList()
        } else {
            bookmarkList
        }

        return bookmarkList.toList()
    }

    override suspend fun cancelBookmarkId(id: Int): List<Int> {
        bookmarkList.remove(id)
        return bookmarkList.toList()
    }

    override suspend fun addBookmarkId(id: Int): List<Int> {
        bookmarkList.add(id)
        return bookmarkList.toList()
    }
}