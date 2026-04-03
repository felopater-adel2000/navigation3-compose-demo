package com.example.authmodule.splash

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val splashModule = module {
    viewModelOf(::SplashViewModel)
}