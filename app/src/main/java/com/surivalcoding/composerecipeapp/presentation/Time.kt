package com.surivalcoding.composerecipeapp.presentation

enum class Time(override val displayName: String) : FilterType {
    ALL("All"),
    NEWEST("Newest"),
    OLDEST("Oldest"),
    POPULARITY("Popularity"),   // 디자인 참고
}