package com.surivalcoding.composerecipeapp.domain.use_case

import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository
import javax.inject.Inject

class GetSearchRecipesUseCase @Inject constructor(
    private val recipeRepository: RecipeRepository,
) {
    suspend fun execute(): List<Recipe> {
        return recipeRepository.getRecipes()
    }
}