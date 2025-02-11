package com.surivalcoding.composerecipeapp.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeDto(
    val category: String? = null,
    val id: Int? = null,
    @SerialName("name") val title: String? = null,
    @SerialName("image") val thumbnailUrl: String? = null,
    val chef: String? = null,
    @SerialName("time") val cookingDuration: String? = null,
    @SerialName("rating") val starRate: Double? = null,
    @SerialName("date") val createdAt: String? = null,
    val ingredients: List<IngredientDto>? = null,
)