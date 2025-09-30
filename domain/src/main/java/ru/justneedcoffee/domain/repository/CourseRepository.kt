package ru.justneedcoffee.domain.repository

import ru.justneedcoffee.domain.model.CourseModel

// TODO: переписать на flow
interface CourseRepository {
    suspend fun loadCourses(): List<CourseModel>
    suspend fun getFavoriteCourses(): List<CourseModel>
    suspend fun setFavoriteCourse(course: CourseModel)
}