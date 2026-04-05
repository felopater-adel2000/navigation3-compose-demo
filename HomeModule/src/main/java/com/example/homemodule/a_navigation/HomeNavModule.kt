package com.example.homemodule.a_navigation

import com.example.basemodule.navigation.NavModuleKey
import kotlinx.serialization.Serializable


sealed interface HomeNavModule : NavModuleKey {

    @Serializable
    class VisitsScreen : HomeNavModule {
        companion object {

            fun toMapsScreen() = MapsScreen()
            fun toClientsScreen() = ClientsScreen()
            fun toProfileScreen() = ProfileScreen()

        }
    }

    @Serializable
    class MapsScreen : HomeNavModule {
        companion object {

            fun toVisitsScreen() = VisitsScreen()
            fun toClientsScreen() = ClientsScreen()
            fun toProfileScreen() = ProfileScreen()

        }
    }

    @Serializable
    class ClientsScreen : HomeNavModule {
        companion object {

            fun toVisitsScreen() = VisitsScreen()
            fun toMapsScreen() = MapsScreen()
            fun toProfileScreen() = ProfileScreen()

        }
    }

    @Serializable
    class ProfileScreen : HomeNavModule {
        companion object {

            fun toVisitsScreen() = VisitsScreen()
            fun toMapsScreen() = MapsScreen()
            fun toClientsScreen() = ClientsScreen()

        }
    }

}