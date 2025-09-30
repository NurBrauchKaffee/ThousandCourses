package ru.justneedcoffee.domain.usecase;

import ru.justneedcoffee.domain.model.CourseModel

class SortCoursesUseCase {
    suspend fun execute(courses: List<CourseModel>): List<CourseModel> =
        courses.sortedByDescending { it.publishDate }
}
