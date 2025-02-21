package com.surivalcoding.composerecipeapp.data.local.repository

import com.surivalcoding.composerecipeapp.data.local.dao.RecipeDao
import com.surivalcoding.composerecipeapp.data.local.mapper.toRecipe
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val recipeDao: RecipeDao,
) : RecipeRepository {

    override suspend fun getRecipes(): List<Recipe> {
        return recipeDao.getAll().map { entity ->
            entity.toRecipe()
        }
    }
}