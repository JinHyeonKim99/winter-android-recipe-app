package com.surivalcoding.composerecipeapp.domain

import com.surivalcoding.composerecipeapp.domain.repository.BookmarkRepository
import javax.inject.Inject

class GetBookmarkUseCase @Inject constructor(
    private val bookmarkRepository: BookmarkRepository,
) {
    suspend fun execute(id: Int = 0, isAdd: Boolean = true): List<Int> {
        return if (id == 0) {
            bookmarkRepository.getAllBookmarkIds()
        } else {
            if (isAdd) {
                bookmarkRepository.addBookmarkId(id)
            } else {
                bookmarkRepository.cancelBookmarkId(id)
            }
        }
    }
}