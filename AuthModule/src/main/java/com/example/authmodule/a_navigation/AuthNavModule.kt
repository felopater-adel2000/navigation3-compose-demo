package com.example.authmodule.a_navigation

import com.example.basemodule.navigation.NavModuleKey
import kotlinx.serialization.Serializable


sealed interface AuthNavModule : NavModuleKey {

    @Serializable
    data object SplashScreen : AuthNavModule

    @Serializable
    data object LoginScreen : AuthNavModule

    @Serializable
    data class VerifyCodeScreen(val phoneNumber: String) : AuthNavModule

}
