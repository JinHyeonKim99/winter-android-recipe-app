package com.surivalcoding.composerecipeapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Entity
data class RecipeEntity(
    val category: String? = null,
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @SerialName("name") val title: String? = null,
    @SerialName("image") val thumbnailUrl: String? = null,
    val chef: String? = null,
    @SerialName("time") val cookingDuration: String? = null,
    @SerialName("rating") val starRate: Double? = null,
    @SerialName("date") val createdAt: String? = null,
)