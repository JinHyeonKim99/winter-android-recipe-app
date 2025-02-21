package com.surivalcoding.composerecipeapp.data.remote.repository

import com.surivalcoding.composerecipeapp.data.remote.data_source.RecipeDataSource
import com.surivalcoding.composerecipeapp.data.remote.mapper.toRecipe
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor (private val dataSource: RecipeDataSource) : RecipeRepository {
    override suspend fun getRecipes(): List<Recipe> {
       return dataSource.getRecipes().map { it.toRecipe() }
    }
}