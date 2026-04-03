package com.example.homemodule.a_navigation

import com.example.basemodule.navigation.NavModuleKey
import kotlinx.serialization.Serializable


sealed interface HomeNavModule : NavModuleKey {

    @Serializable
    object VisitsScreen : HomeNavModule

}