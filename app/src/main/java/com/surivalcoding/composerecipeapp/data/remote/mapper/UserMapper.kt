package com.surivalcoding.composerecipeapp.data.remote.mapper

import com.surivalcoding.composerecipeapp.data.remote.dto.UserDto
import com.surivalcoding.composerecipeapp.domain.model.User

fun UserDto.toUser() = User(
    userId = userId ?: 0,
    name = name ?: "",
    savedRecipesId = savedRecipesId ?: emptyList()
)