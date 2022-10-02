package com.vitorhr.locator

import android.app.Application
import com.google.firebase.FirebaseApp
import com.vitorhr.locator.di.viewModelModule
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(baseContext)
        startKoin {
            modules(
                viewModelModule
            )
        }
    }
}