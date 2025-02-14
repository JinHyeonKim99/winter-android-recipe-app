package com.surivalcoding.composerecipeapp.domain.usecase

import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.domain.repository.BookmarkRepository
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository
import javax.inject.Inject

class GetSavedRecipesUseCase @Inject constructor(
    private val recipeRepository: RecipeRepository,
    private val bookmarkRepository: BookmarkRepository,
) {
    suspend fun execute(id: Int = 0): List<Recipe> {
        return if (id == 0) {
            recipeRepository.getRecipes().filter {
                it.id in bookmarkRepository.getAllBookmarkIds()
            }
        } else {
            recipeRepository.getRecipes().filter {
                it.id in bookmarkRepository.cancelBookmarkId(id)
            }
        }
    }
}