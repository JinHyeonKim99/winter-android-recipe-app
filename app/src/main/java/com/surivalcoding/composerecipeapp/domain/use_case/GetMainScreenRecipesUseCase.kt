package com.surivalcoding.composerecipeapp.domain.use_case

import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.core.util.Result
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository
import javax.inject.Inject


class GetMainScreenRecipesUseCase @Inject constructor(
    private val recipeRepository: RecipeRepository,
) {
    suspend fun execute(): Result<List<Recipe>> {
        return try {
            Result.Success(
                recipeRepository.getRecipes()
            )
        } catch (e: Exception) {
            Result.Error(
                message = "레시피 로드 에러 (네트워크 에러)",
                throwable = e,
            )
        }
    }
}