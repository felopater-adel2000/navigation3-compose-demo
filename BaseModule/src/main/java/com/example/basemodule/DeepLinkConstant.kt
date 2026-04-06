package com.example.basemodule

import com.example.basemodule.navigation.Nav3Controller


class DeepLinkConstant private constructor(
    val visitsScreenDeepLink: String,
    val loginScreenDeepLink: String,
    val retailerNameScreenDeepLink: String,
    val clientsScreenDeepLink: String
) {

    companion object {
        private var INSTANCE: DeepLinkConstant? = null
        fun initialize(
            visitsScreenDeepLink: String,
            loginScreenDeepLink: String,
            retailerNameScreenDeepLink: String,
            clientsScreenDeepLink: String
        ) {
            if (INSTANCE == null) {
                INSTANCE = DeepLinkConstant(
                    visitsScreenDeepLink = visitsScreenDeepLink,
                    loginScreenDeepLink = loginScreenDeepLink,
                    retailerNameScreenDeepLink = retailerNameScreenDeepLink,
                    clientsScreenDeepLink = clientsScreenDeepLink
                )
            }
        }

        fun getInstance(): DeepLinkConstant {
            return INSTANCE
                ?: throw IllegalStateException("DeepLinkConstant is not initialized. Call initialize() first.")
        }
    }
}
