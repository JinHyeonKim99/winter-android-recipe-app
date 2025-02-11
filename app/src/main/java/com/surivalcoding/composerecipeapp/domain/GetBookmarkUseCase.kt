package com.surivalcoding.composerecipeapp.domain

import com.surivalcoding.composerecipeapp.domain.repository.BookmarkRepository
import javax.inject.Inject

class GetBookmarkUseCase @Inject constructor(
    private val bookmarkRepository: BookmarkRepository,
) {
    fun execute(): BookmarkRepository {
        return bookmarkRepository
    }
}