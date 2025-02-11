package com.surivalcoding.composerecipeapp.domain.model

import kotlinx.serialization.SerialName

data class Recipe(
    val category: String,
    val id: Int,
    @SerialName("name") val title: String,
    @SerialName("image") val thumbnailUrl: String,
    val chef: String? = "By Chef",
    @SerialName("time") val cookingDuration: String,
    @SerialName("rating") val starRate: Double,
    @SerialName("date") val createdAt: String,
    val ingredients: List<Ingredient>,
) {
    val procedure: String = ""
    val editedAt: String = ""
    val savedCount: String = ""
    val serving: String = ""
    val videoUrl: String = ""
    val shareUrl: String = ""
}