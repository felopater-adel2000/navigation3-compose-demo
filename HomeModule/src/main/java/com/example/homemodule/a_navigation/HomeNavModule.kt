package com.example.homemodule.a_navigation

import com.example.basemodule.navigation.NavModuleKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface HomeNavModule : NavModuleKey {

    object VisitsScreen : HomeNavModule

}