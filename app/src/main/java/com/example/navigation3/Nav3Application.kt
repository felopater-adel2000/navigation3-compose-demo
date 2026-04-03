package com.example.navigation3

import android.app.Application
import android.util.Log
import com.example.authmodule.di.authDI
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class Nav3Application : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d("TAG", "onCreate: ")


        startKoin {
            androidLogger()
            androidContext(this@Nav3Application)
            authDI()
        }
    }
}