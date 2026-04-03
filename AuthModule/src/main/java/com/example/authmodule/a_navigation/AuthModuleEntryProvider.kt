package com.example.authmodule.a_navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.example.authmodule.login.LoginScreen
import com.example.authmodule.splash.SplashScreen
import com.example.authmodule.verifyCode.VerifyCodeScreen


fun EntryProviderScope<NavKey>.authModuleEntryProvider() {

    entry<AuthNavModule.SplashScreen> {
        SplashScreen()
    }
    entry<AuthNavModule.LoginScreen> {
        LoginScreen()
    }
    entry<AuthNavModule.VerifyCodeScreen> { args ->
        VerifyCodeScreen(args)
    }

}