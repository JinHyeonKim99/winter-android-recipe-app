package com.surivalcoding.composerecipeapp.presentation

enum class Rate(override val displayName: String) : FilterType {
    ALL("All"),
    ONE("1"),
    TWO("2"),
    Three("3"),
    FOUR("4"),
    FIVE("5"),
}