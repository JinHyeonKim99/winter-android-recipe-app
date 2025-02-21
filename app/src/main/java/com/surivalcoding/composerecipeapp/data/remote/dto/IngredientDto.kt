package com.surivalcoding.composerecipeapp.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class IngredientDto(
    val id: Int? = null,
    val name: String? = null,
    @SerialName("image") val imageUrl: String? = null,
    @SerialName("amount") val weight: Int? = null,
)