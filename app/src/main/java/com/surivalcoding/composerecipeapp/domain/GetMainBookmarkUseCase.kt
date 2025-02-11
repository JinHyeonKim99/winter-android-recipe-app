package com.surivalcoding.composerecipeapp.domain

import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.domain.repository.BookmarkRepository
import javax.inject.Inject

//class GetMainBookmarkUseCase @Inject constructor(
//    private val bookmarkRepository: BookmarkRepository,
//) {
//    suspend fun execute(id: Int = 0): List<Recipe> {
//        return recipeRepository.getRecipes().filter {
//            it.id in bookmarkUseCase.execute(id)
//        }
//    }
//}