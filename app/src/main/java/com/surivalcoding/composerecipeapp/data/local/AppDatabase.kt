package com.surivalcoding.composerecipeapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.surivalcoding.composerecipeapp.data.local.dao.RecipeDao
import com.surivalcoding.composerecipeapp.data.local.entity.RecipeEntity

@Database(entities = [RecipeEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}