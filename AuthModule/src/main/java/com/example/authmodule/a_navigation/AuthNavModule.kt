package com.example.authmodule.a_navigation

import com.example.basemodule.DeepLinkConstant
import com.example.basemodule.navigation.NavModuleKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface AuthNavModule : NavModuleKey {
    data object SplashScreen : AuthNavModule {
        fun toLoginScreen() = LoginScreen

        fun toVisitsScreen() = NavModuleKey.createInstance(DeepLinkConstant.VISITS_SCREEN)
    }

    data object LoginScreen : AuthNavModule {
        fun toVerifyCodeScreen(phoneNumber: String) = VerifyCodeScreen(phoneNumber)
    }

    data class VerifyCodeScreen(val phoneNumber: String) : AuthNavModule {
        companion object {
            fun toVisitsScreen() = NavModuleKey.createInstance(DeepLinkConstant.VISITS_SCREEN)
        }
    }

}
