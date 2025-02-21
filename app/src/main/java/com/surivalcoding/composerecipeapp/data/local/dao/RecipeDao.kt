package com.surivalcoding.composerecipeapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.surivalcoding.composerecipeapp.data.local.entity.RecipeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {
//    @Query("SELECT * FROM recipeEntity")
//    suspend fun getAll(): List<RecipeEntity?>

    @Query("SELECT * FROM recipeEntity")
    fun getAll(): List<RecipeEntity>   // Flow는 변경 될 때만 올라옴

    @Query("SELECT * FROM recipeEntity WHERE id = :id")
    suspend fun getById(id: Int): RecipeEntity

    @Query("SELECT id FROM recipeEntity")
    suspend fun getAllBookmarkIds(): List<Int>

    @Upsert
    suspend fun upsert(recipeEntity: RecipeEntity)  // Insert, Update 동시에 가능

//    @Insert
//    fun insert(recipe: Recipe)
//
//    @Update
//    fun update(recipe: Recipe)

    @Delete
    suspend fun delete(recipeEntity: RecipeEntity)


}