package com.example.authmodule.di

import com.example.authmodule.login.loginModule
import com.example.authmodule.splash.splashModule
import com.example.authmodule.verifyCode.verifyModule
import org.koin.core.KoinApplication

fun KoinApplication.authDI()  {
    modules(
        splashModule,
        loginModule,
        verifyModule
    )
}