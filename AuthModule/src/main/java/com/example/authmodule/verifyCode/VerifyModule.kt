package com.example.authmodule.verifyCode

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val verifyModule = module {
    viewModelOf(::VerifyViewModel)
}