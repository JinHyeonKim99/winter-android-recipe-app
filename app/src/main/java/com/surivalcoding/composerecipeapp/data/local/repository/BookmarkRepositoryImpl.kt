package com.surivalcoding.composerecipeapp.data.local.repository

import com.surivalcoding.composerecipeapp.data.local.dao.RecipeDao
import com.surivalcoding.composerecipeapp.domain.repository.BookmarkRepository
import javax.inject.Inject

class BookmarkRepositoryImpl @Inject constructor(
    private val recipeDao: RecipeDao,
) : BookmarkRepository {

    override suspend fun getAllBookmarkIds(userId: Int): List<Int> {
        return recipeDao.getAllBookmarkIds()
    }

    override suspend fun cancelBookmarkId(recipeId: Int): List<Int> {
        recipeDao.delete(recipeDao.getById(recipeId))
        return getAllBookmarkIds()
    }

    override suspend fun addBookmarkId(recipeId: Int): List<Int> {
        recipeDao.upsert(recipeDao.getById(recipeId))
        return getAllBookmarkIds()
    }

}