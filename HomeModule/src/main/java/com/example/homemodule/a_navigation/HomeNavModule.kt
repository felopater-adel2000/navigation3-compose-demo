package com.example.homemodule.a_navigation

import com.example.basemodule.navigation.NavModuleKey
import kotlinx.serialization.Serializable


sealed interface HomeNavModule : NavModuleKey {

    @Serializable
    class VisitsScreen : HomeNavModule {
        companion object {

        }
    }

    @Serializable
    class MapScreen : HomeNavModule {
        companion object {

        }
    }

    @Serializable
    class ClientsScreen : HomeNavModule {
        companion object {

        }
    }

    @Serializable
    class ProfileScreen : HomeNavModule {
        companion object {

        }
    }

}