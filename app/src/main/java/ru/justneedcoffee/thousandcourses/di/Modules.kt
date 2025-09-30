package ru.justneedcoffee.thousandcourses.di

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.justneedcoffee.data.api.CourseApi
import ru.justneedcoffee.data.repository.impl.CourseRepositoryImpl
import ru.justneedcoffee.domain.repository.CourseRepository
import ru.justneedcoffee.domain.usecase.LoadCoursesUseCase

private const val BASE_URL = "https://drive.usercontent.google.com/u/0/"

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CourseApi::class.java)
    }
}

val domainModule = module {
    factory<LoadCoursesUseCase>{ LoadCoursesUseCase(get()) }
}

val dataModule = module {
    single<CourseRepository>{ CourseRepositoryImpl(get(), get()) }
}