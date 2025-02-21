package com.surivalcoding.composerecipeapp.data.remote.data_source

import com.surivalcoding.composerecipeapp.data.remote.dto.RecipeDto

interface RecipeDataSource {
    suspend fun getRecipes(): List<RecipeDto>
}