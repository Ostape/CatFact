package com.robosh.catfact.application

import android.app.Application
import com.robosh.catfact.details.di.detailsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RoboshApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@RoboshApplication)
            modules(
                detailsModule
            )
        }
    }
}