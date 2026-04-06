package com.example.authmodule.verifyCode

import com.example.authmodule.a_navigation.AuthNavModule
import com.example.basemodule.navigation.Nav3Controller
import com.example.basemodule.navigation.ScreenDirection

sealed interface VerifyDirection : ScreenDirection {

    object NavigateToHome : VerifyDirection {
        override fun execute(controller: Nav3Controller) {
            val direction = AuthNavModule.VerifyCodeScreen.toVisitsScreen()
            controller.navigate(direction) {
                popUpTo(AuthNavModule::class.java, inclusive = true)
            }
        }
    }

    class NavigateBackWithError(val error: String) : VerifyDirection {
        override fun execute(controller: Nav3Controller) {
            controller.popBackStack {
                setResult(AuthNavModule.LoginScreen::class.java.name) {
                    putString("error", error)
                }
                popUpTo(AuthNavModule.VerifyCodeScreen::class.java, inclusive = true)
            }
        }

    }

}