package com.example.acquireretailer.a_navifation

import android.os.Bundle
import com.example.basemodule.DeepLinkConstant
import com.example.basemodule.navigation.NavModuleKey
import kotlinx.serialization.Serializable

sealed interface AcquireRetailerNavModule : NavModuleKey {

    @Serializable
    data object RetailerNameScreen : AcquireRetailerNavModule {
        fun toRetailerAddressScreen(retailerName: String) = RetailerAddressScreen(retailerName)
    }


    @Serializable
    class RetailerAddressScreen(val retailerName: String) : AcquireRetailerNavModule {
        companion object {
            fun toClientsScreen() =
                NavModuleKey.createInstance(DeepLinkConstant.getInstance().clientsScreenDeepLink)
        }
    }
}