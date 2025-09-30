package ru.justneedcoffee.domain.usecase

import ru.justneedcoffee.domain.model.CourseModel
import ru.justneedcoffee.domain.repository.CourseRepository

class SetFavoriteCourseUseCase(private val courseRepository: CourseRepository) {
    suspend fun execute(course: CourseModel) = courseRepository.setFavoriteCourse(course)
}