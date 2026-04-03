package com.example.authmodule

import androidx.navigation3.runtime.NavKey
import com.example.basemodule.NavModuleKey
import kotlinx.serialization.Serializable


sealed interface AuthNavModule : NavModuleKey {

    @Serializable
    data object SplashScreen : AuthNavModule

    @Serializable
    data object LoginScreen : AuthNavModule

    @Serializable
    data class VerifyCodeScreen(val phoneNumber: String) : AuthNavModule

}
