package ru.justneedcoffee.domain.usecase

import ru.justneedcoffee.domain.model.CourseModel
import ru.justneedcoffee.domain.repository.CourseRepository

class GetFavoriteCoursesUseCase(private val courseRepository: CourseRepository) {
    suspend fun execute(): List<CourseModel> = courseRepository.getFavoriteCourses()
}