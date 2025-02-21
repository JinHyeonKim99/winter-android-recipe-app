package com.surivalcoding.composerecipeapp.data.remote.data_source

import com.surivalcoding.composerecipeapp.data.remote.dto.UserDto

interface UserDataSource {
    suspend fun getAllUsers() : List<UserDto>

    suspend fun getUserById(id: Int) : List<UserDto>
}