package com.example.acquireretailer.a_navifation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey

fun EntryProviderScope<NavKey>.acquireRetailerModuleEntryProvider() {

    entry<AcquireRetailerNavModule.RetailerNameScreen> {
        RetailerNameScreen()
    }

    entry<AcquireRetailerNavModule.RetailerAddressScreen> {
        RetailerAddressScreen(it)
    }

}