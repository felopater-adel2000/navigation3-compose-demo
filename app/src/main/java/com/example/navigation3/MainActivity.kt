package com.example.navigation3

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.example.acquireretailer.a_navifation.AcquireRetailerNavModule
import com.example.acquireretailer.a_navifation.acquireRetailerModuleEntryProvider
import com.example.authmodule.a_navigation.AuthNavModule
import com.example.authmodule.a_navigation.authModuleEntryProvider
import com.example.basemodule.DeepLinkConstant
import com.example.basemodule.navigation.LocalNav3Controller
import com.example.basemodule.navigation.Nav3ControllerImpl
import com.example.homemodule.a_navigation.BottomNavBar
import com.example.homemodule.a_navigation.HomeNavModule
import com.example.homemodule.a_navigation.homeModuleEntryProvider
import com.example.navigation3.ui.theme.Navigation3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val splashScreenName = AuthNavModule.SplashScreen::class.java.name
        Log.d("MainActivity", "Splash Screen Name: $splashScreenName")

        DeepLinkConstant.initialize(
            visitsScreenDeepLink = HomeNavModule.VisitsScreen::class.java.name,
            loginScreenDeepLink = AuthNavModule.LoginScreen::class.java.name,
            retailerNameScreenDeepLink = AcquireRetailerNavModule.RetailerNameScreen::class.java.name,
            clientsScreenDeepLink = HomeNavModule.ClientsScreen::class.java.name
        )

        setContent {
            Navigation3Theme {
                AppNav()

            }
        }
    }
}


@Composable
fun AppNav(
    backStack: NavBackStack<NavKey> = rememberNavBackStack(AuthNavModule.SplashScreen())
) {
    CompositionLocalProvider(
        LocalNav3Controller provides Nav3ControllerImpl(backStack)
    ) {

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                if(backStack.lastOrNull() is HomeNavModule) {
                    BottomNavBar()
                }
            }
        ) { paddingValues ->
            NavDisplay(
                modifier = Modifier.fillMaxSize().padding(paddingValues),
                entryDecorators = listOf(
                    rememberSaveableStateHolderNavEntryDecorator(),
                    rememberViewModelStoreNavEntryDecorator()
                ),
                backStack = backStack,
                onBack = { backStack.removeLastOrNull() },
                entryProvider = entryProvider {
                    authModuleEntryProvider()
                    homeModuleEntryProvider()
                    acquireRetailerModuleEntryProvider()
                }
            )
        }

    }
}
