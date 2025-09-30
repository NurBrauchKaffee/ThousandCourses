package ru.justneedcoffee.data.utils

import ru.justneedcoffee.data.api.CourseResponseModel
import ru.justneedcoffee.data.db.CourseEntity
import ru.justneedcoffee.domain.model.CourseModel

fun CourseResponseModel.toCourseModel(): CourseModel = CourseModel(
    id,
    title,
    text,
    price,
    rate.toDouble(),
    startDate,
    hasLike,
    publishDate
)

fun CourseModel.toCourseEntity(): CourseEntity = CourseEntity(
    id,
    title,
    text,
    price,
    rate,
    startDate,
    publishDate
)

fun CourseEntity.toCourseModel(): CourseModel = CourseModel(
    id,
    title,
    text,
    price,
    rate,
    startDate,
    hasLike = true,
    publishDate
)