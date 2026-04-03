package com.example.basemodule

import androidx.compose.runtime.staticCompositionLocalOf

interface NavController3 {

    fun navigate(key: NavModuleKey)

    fun navigate(keyName: String, vararg args: Any)

    fun popBackStack()
}

val LocalNavController3 = staticCompositionLocalOf<NavController3> {
    error("No NavController3 provided")
}