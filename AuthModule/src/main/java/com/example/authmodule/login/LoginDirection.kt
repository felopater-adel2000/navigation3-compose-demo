package com.example.authmodule.login

import com.example.authmodule.a_navigation.AuthNavModule
import com.example.basemodule.navigation.Nav3Controller
import com.example.basemodule.navigation.ScreenDirection

sealed interface LoginDirection : ScreenDirection {

    class NavigateToVerification(val phoneNumber: String) : LoginDirection {
        override fun execute(controller: Nav3Controller) {
            val direction = AuthNavModule.LoginScreen.toVerifyCodeScreen(phoneNumber)
            controller.navigate(direction)
        }

    }

}