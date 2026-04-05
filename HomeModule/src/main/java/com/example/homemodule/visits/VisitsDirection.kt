package com.example.homemodule.visits

import com.example.basemodule.navigation.Nav3Controller
import com.example.basemodule.navigation.NavModuleKey
import com.example.basemodule.navigation.ScreenDirection
import com.example.homemodule.a_navigation.HomeNavModule

sealed interface VisitsDirection : ScreenDirection {

    object NavigateToLogin : VisitsDirection {
        override fun execute(controller: Nav3Controller) {
            val direction = HomeNavModule.VisitsScreen.toLoginScreen()
            controller.navigate(direction) {
                popUpTo(NavModuleKey::class.java, inclusive = true)
            }
        }

    }

}