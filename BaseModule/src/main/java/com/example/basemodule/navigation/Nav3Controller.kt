package com.example.basemodule.navigation

import android.os.Bundle
import androidx.compose.runtime.staticCompositionLocalOf

interface Nav3Controller {

    fun navigate(key: NavModuleKey, optionsBuilder: (Nav3BuilderOptions.() -> Unit)? = null)

    fun navigate(keyName: String, vararg args: Any, optionsBuilder: (Nav3BuilderOptions.() -> Unit)? = null)

    fun popBackStack(optionsBuilder: (Nav3BuilderOptions.() -> Unit))

    fun popBackStack()

    fun clearBackStack()

    fun getResultManager(): NavResultManager
}

val LocalNav3Controller = staticCompositionLocalOf<Nav3Controller> {
    error("No NavController3 provided")
}