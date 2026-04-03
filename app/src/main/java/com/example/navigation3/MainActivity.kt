package com.example.navigation3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.CompositionLocalProvider
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.example.authmodule.a_navigation.AuthNavModule
import com.example.authmodule.a_navigation.authModuleEntryProvider
import com.example.basemodule.navigation.LocalNav3Controller
import com.example.basemodule.navigation.Nav3ControllerImpl
import com.example.homemodule.a_navigation.homeModuleEntryProvider
import com.example.navigation3.ui.theme.Navigation3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Navigation3Theme {
                val backStack = rememberNavBackStack(AuthNavModule.SplashScreen())
                CompositionLocalProvider(
                    LocalNav3Controller provides Nav3ControllerImpl(backStack)
                ) {

                    NavDisplay(
                        entryDecorators = listOf(
                            rememberSaveableStateHolderNavEntryDecorator(),
                            rememberViewModelStoreNavEntryDecorator()
                        ),
                        backStack = backStack,
                        onBack = { backStack.removeLastOrNull() },
                        entryProvider = entryProvider {
                            authModuleEntryProvider()

                            homeModuleEntryProvider()
                        }
                    )

                }
            }
        }
    }
}
