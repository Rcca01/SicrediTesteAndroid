package com.example.sicrediandroidtest

import android.app.Application
import com.example.sicrediandroidtest.di.androidModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppApplication)
            modules(androidModule)
        }
    }
}