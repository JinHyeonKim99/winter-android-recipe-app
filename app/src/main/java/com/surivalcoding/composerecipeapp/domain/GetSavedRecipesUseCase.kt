package com.surivalcoding.composerecipeapp.domain

import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository
import javax.inject.Inject

class GetSavedRecipesUseCase @Inject constructor(
    private val recipeRepository: RecipeRepository,
    private val getBookmarkUseCase: GetBookmarkUseCase,
) {
    suspend fun execute(id: Int = 0): List<Recipe> {
        return if (id == 0) {
            recipeRepository.getRecipes().filter {
                it.id in getBookmarkUseCase.execute().getBookmarkId()
            }
        } else {
            recipeRepository.getRecipes().filter {
                it.id in getBookmarkUseCase.execute().cancelBookmarkId(id)
            }
        }
    }
}