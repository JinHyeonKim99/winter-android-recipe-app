package com.surivalcoding.composerecipeapp.domain.use_case

import com.surivalcoding.composerecipeapp.domain.repository.BookmarkRepository
import javax.inject.Inject

class GetBookmarkUseCase @Inject constructor(
    private val bookmarkRepository: BookmarkRepository,
) {
    suspend fun execute(recipeId: Int = 0, isAdd: Boolean = true): List<Int> {
        return if (recipeId == 0) {
            bookmarkRepository.getAllBookmarkIds()
        } else {
            if (isAdd) {
                bookmarkRepository.addBookmarkId(recipeId)
            } else {
                bookmarkRepository.cancelBookmarkId(recipeId)
            }
        }
    }
}