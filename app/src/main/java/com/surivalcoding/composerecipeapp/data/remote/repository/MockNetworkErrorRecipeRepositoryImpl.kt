package com.surivalcoding.composerecipeapp.data.remote.repository

import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository
import okio.IOException
import javax.inject.Inject

class MockNetworkErrorRecipeRepositoryImpl @Inject constructor() : RecipeRepository {
    override suspend fun getRecipes(): List<Recipe> {
        throw IOException("Network Error")
    }
}