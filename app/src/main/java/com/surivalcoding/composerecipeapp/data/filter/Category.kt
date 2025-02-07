package com.surivalcoding.composerecipeapp.data.filter

enum class Category(override val displayName: String) : FilterType {
    ALL("All"),
    INDIAN("Indian"),
    ITALIAN("Italian"),
    ASIAN("Asian"),
    CHINESE("Chinese"),
    FRUIT("Fruit"),
    VEGETABLES("Vegetables"),
    PROTEIN("Protein"),
    CEREAL("Cereal"),
    LOCAL_DISHES("Local Dishes"),
}