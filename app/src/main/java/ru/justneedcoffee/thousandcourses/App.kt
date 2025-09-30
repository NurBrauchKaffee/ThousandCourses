package ru.justneedcoffee.thousandcourses

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import ru.justneedcoffee.thousandcourses.di.dataModule
import ru.justneedcoffee.thousandcourses.di.domainModule
import ru.justneedcoffee.thousandcourses.di.networkModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                networkModule,
                domainModule,
                dataModule
            )
        }

    }

}