package com.example.homemodule.a_navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.example.homemodule.visits.VisitsScreen

fun EntryProviderScope<NavKey>.homeModuleEntryProvider() {

    entry<HomeNavModule.VisitsScreen> {
        VisitsScreen()
    }

}