package com.example.acquireretailer.a_navifation

import com.example.basemodule.DeepLinkConstant
import com.example.basemodule.navigation.NavModuleKey
import kotlinx.serialization.Serializable

sealed interface AcquireRetailerNavModule : NavModuleKey {

    @Serializable
    class RetailerNameScreen : AcquireRetailerNavModule {
        companion object {
            fun toRetailerAddressScreen(retailerName: String) = RetailerAddressScreen(retailerName)
        }
    }


    @Serializable
    class RetailerAddressScreen(val retailerName: String) : AcquireRetailerNavModule {
        companion object {
            fun toClientsScreen() =
                NavModuleKey.createInstance(DeepLinkConstant.getInstance().clientsScreenDeepLink)
        }
    }
}