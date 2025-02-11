package com.surivalcoding.composerecipeapp.data.mapper

import com.surivalcoding.composerecipeapp.data.dto.IngredientDto
import com.surivalcoding.composerecipeapp.data.dto.RecipeDto
import com.surivalcoding.composerecipeapp.domain.model.Ingredient
import com.surivalcoding.composerecipeapp.domain.model.Recipe

fun RecipeDto.toRecipe() = Recipe(
    category = category ?: "",
    id = id ?: 0,
    title = title ?: "",
    thumbnailUrl = thumbnailUrl ?: "",
    chef = chef ?: "",
    cookingDuration = cookingDuration ?: "",
    starRate = starRate ?: 0.0,
    createdAt = createdAt ?: "",
    ingredients = ingredients?.map { it.toIngredient() } ?: emptyList()
)

fun IngredientDto.toIngredient() = Ingredient(
    id = id ?: 0,
    name = name ?: "",
    imageUrl = imageUrl ?: "",
    weight = weight ?: 0,
)
