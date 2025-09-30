package ru.justneedcoffee.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CourseDao {
    @Query("SELECT * FROM favorites")
    fun getFavorites(): List<CourseEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(course: CourseEntity)

    @Delete
    suspend fun delete(course: CourseEntity)
}