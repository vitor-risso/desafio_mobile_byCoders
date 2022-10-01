package com.vitorhr.locator

import android.app.Application
import com.vitorhr.locator.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                viewModelModule
            )
        }
    }
}