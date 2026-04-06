package com.example.acquireretailer.a_navifation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.example.acquireretailer.retailername.RetailerNameScreen
import com.example.acquireretailer.marketname.MarketNameScreen

fun EntryProviderScope<NavKey>.acquireRetailerModuleEntryProvider() {

    entry<AcquireRetailerNavModule.RetailerNameScreen> {
        RetailerNameScreen()
    }

    entry<AcquireRetailerNavModule.RetailerAddressScreen> {
        MarketNameScreen(it)
    }

}