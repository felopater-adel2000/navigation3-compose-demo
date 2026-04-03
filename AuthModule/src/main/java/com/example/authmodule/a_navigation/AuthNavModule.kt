package com.example.authmodule.a_navigation

import com.example.basemodule.DeepLinkConstant
import com.example.basemodule.navigation.NavModuleKey
import kotlinx.serialization.Serializable


sealed interface AuthNavModule : NavModuleKey {
    @Serializable
    data object SplashScreen : AuthNavModule {
        fun toLoginScreen() = LoginScreen

        fun toVisitsScreen() = NavModuleKey.createInstance(DeepLinkConstant.VISITS_SCREEN)
    }

    @Serializable
    data object LoginScreen : AuthNavModule {
        fun toVerifyCodeScreen(phoneNumber: String) = VerifyCodeScreen(phoneNumber)
    }

    @Serializable
    data class VerifyCodeScreen(val phoneNumber: String) : AuthNavModule {
        companion object {
            fun toVisitsScreen() = NavModuleKey.createInstance(DeepLinkConstant.VISITS_SCREEN)
        }
    }

}
