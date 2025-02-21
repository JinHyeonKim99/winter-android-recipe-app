package com.surivalcoding.composerecipeapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
class UserDto(
    val userId: Int? = null,
    val name: String? = null,
    val savedRecipesId: List<Int>? = null
)