package com.lutfi.newstabapp

import android.app.Application
import com.lutfi.newstabapp.di.dbModule
import com.lutfi.newstabapp.di.repositoryModule
import com.lutfi.newstabapp.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // start Koin
        startKoin{
            androidContext(this@MainApplication)
            modules(listOf(dbModule, repositoryModule, uiModule))
        }
    }
}