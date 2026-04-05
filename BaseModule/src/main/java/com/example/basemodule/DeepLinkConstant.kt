package com.example.basemodule

import com.example.basemodule.navigation.Nav3Controller


class DeepLinkConstant private constructor(
    val visitsScreenDeepLink: String,
    val loginScreenDeepLink: String
) {

    companion object {
        private var INSTANCE: DeepLinkConstant? = null
        fun initialize(
            visitsScreenDeepLink: String,
            loginScreenDeepLink: String
        ) {
            if (INSTANCE == null) {
                INSTANCE = DeepLinkConstant(
                    visitsScreenDeepLink = visitsScreenDeepLink,
                    loginScreenDeepLink = loginScreenDeepLink
                )
            }
        }

        fun getInstance(): DeepLinkConstant {
            return INSTANCE
                ?: throw IllegalStateException("DeepLinkConstant is not initialized. Call initialize() first.")
        }
    }
}
