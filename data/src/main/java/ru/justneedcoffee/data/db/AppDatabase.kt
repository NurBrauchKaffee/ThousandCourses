package ru.justneedcoffee.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [CourseEntity::class]
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getCourseDao(): CourseDao
}