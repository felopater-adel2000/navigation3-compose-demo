package com.example.authmodule.di

import com.example.authmodule.login.loginModule
import com.example.authmodule.splash.splashModule
import org.koin.core.KoinApplication

fun KoinApplication.authDI()  {
    modules(
        splashModule,
        loginModule
    )
}