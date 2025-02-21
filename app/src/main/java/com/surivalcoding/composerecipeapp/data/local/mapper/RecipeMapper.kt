package com.surivalcoding.composerecipeapp.data.local.mapper

import com.surivalcoding.composerecipeapp.data.local.entity.RecipeEntity
import com.surivalcoding.composerecipeapp.domain.model.Recipe

fun RecipeEntity.toRecipe() = Recipe(
    category = category ?: "",
    id = id ?: 0,
    title = title ?: "",
    thumbnailUrl = thumbnailUrl ?: "",
    chef = chef ?: "",
    cookingDuration = cookingDuration ?: "",
    starRate = starRate ?: 0.0,
    createdAt = createdAt ?: "",
    ingredients = emptyList()
)