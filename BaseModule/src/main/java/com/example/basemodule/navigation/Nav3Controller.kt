package com.example.basemodule.navigation

import androidx.compose.runtime.staticCompositionLocalOf

interface Nav3Controller {

    fun navigate(key: NavModuleKey)

    fun navigate(keyName: String, vararg args: Any)

    fun popBackStack()
}

val LocalNav3Controller = staticCompositionLocalOf<Nav3Controller> {
    error("No NavController3 provided")
}