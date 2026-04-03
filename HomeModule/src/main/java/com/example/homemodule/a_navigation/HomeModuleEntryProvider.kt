package com.example.homemodule.a_navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.example.homemodule.clients.ClientsScreen
import com.example.homemodule.maps.MapsScreen
import com.example.homemodule.profile.ProfileScreen
import com.example.homemodule.visits.VisitsScreen

fun EntryProviderScope<NavKey>.homeModuleEntryProvider() {

    entry<HomeNavModule.VisitsScreen> {
        VisitsScreen()
    }
    entry<HomeNavModule.MapsScreen> {
        MapsScreen()
    }
    entry<HomeNavModule.ClientsScreen> {
        ClientsScreen()
    }
    entry<HomeNavModule.ProfileScreen> {
        ProfileScreen()
    }

}