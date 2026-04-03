package com.example.authmodule.splash

import com.example.authmodule.a_navigation.AuthNavModule
import com.example.basemodule.navigation.Nav3Controller
import com.example.basemodule.navigation.ScreenDirection

sealed interface SplashDirections : ScreenDirection {

    object NavigateToLogin : SplashDirections {
        override fun execute(controller: Nav3Controller) {
           val direction = AuthNavModule.SplashScreen.toLoginScreen()
            controller.navigate(direction)
        }
    }

    object NavigateToVisits : SplashDirections {
        override fun execute(controller: Nav3Controller) {
            val direction = AuthNavModule.SplashScreen.toVisitsScreen()
            controller.navigate(direction)
        }
    }
}