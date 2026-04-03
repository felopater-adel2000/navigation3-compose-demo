package com.example.authmodule.a_navigation

import com.example.basemodule.DeepLinkConstant
import com.example.basemodule.navigation.NavModuleKey
import kotlinx.serialization.Serializable


sealed interface AuthNavModule : NavModuleKey {
    @Serializable
    class SplashScreen : AuthNavModule {
        companion object {
            fun toLoginScreen() = LoginScreen()

            fun toVisitsScreen() = NavModuleKey.createInstance(DeepLinkConstant.VISITS_SCREEN)
        }
    }

    @Serializable
    class LoginScreen : AuthNavModule {
        companion object {
            fun toVerifyCodeScreen(phoneNumber: String) = VerifyCodeScreen(phoneNumber)
        }
    }

    @Serializable
    class VerifyCodeScreen(val phoneNumber: String) : AuthNavModule {
        companion object {
            fun toVisitsScreen() = NavModuleKey.createInstance(DeepLinkConstant.VISITS_SCREEN)
        }
    }

}
