package ru.justneedcoffee.data.repository.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import ru.justneedcoffee.data.api.CourseApi
import ru.justneedcoffee.data.db.CourseDao
import ru.justneedcoffee.data.utils.toCourseEntity
import ru.justneedcoffee.data.utils.toCourseModel
import ru.justneedcoffee.domain.model.CourseModel
import ru.justneedcoffee.domain.repository.CourseRepository

class CourseRepositoryImpl(private val api: CourseApi,
                           private val dao: CourseDao): CourseRepository {
    override suspend fun loadCourses(): List<CourseModel> {
        val remoteCoursesFlow = flow {
            val courses = api.getCourses().map { it.toCourseModel() }

            courses.filter { it.hasLike }.forEach { course ->
                dao.insert(course.toCourseEntity())
            }

            emit(courses)
        }

        val favoritesFlow: Flow<List<String>> = flow {
            dao.getFavorites().map { it.id.toString() }
        }

        var list = listOf<CourseModel>()
        combine(remoteCoursesFlow, favoritesFlow) { courses, favorites ->
            courses.map { c ->
                c.copy(hasLike = favorites.contains(c.id.toString()))
            }
        }.collect { list = it }

        return list
    }

    override suspend fun getFavoriteCourses(): List<CourseModel> {
        return dao.getFavorites().map {
            it.toCourseModel()
        }
    }

    override suspend fun setFavoriteCourse(course: CourseModel) {
        val entity = course.toCourseEntity()
        if (course.hasLike) {
            dao.delete(entity)
        } else {
            dao.insert(entity)
        }
    }
}