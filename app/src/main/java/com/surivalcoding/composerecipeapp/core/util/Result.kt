package com.surivalcoding.composerecipeapp.core.util

sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error(
        val message: String,
        val throwable: Throwable,
    ) : Result<Nothing>()
}