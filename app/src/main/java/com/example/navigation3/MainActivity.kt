package com.example.navigation3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.authmodule.AuthNavModule
import com.example.authmodule.authModuleEntryProvider
import com.example.basemodule.LocalNavController3
import com.example.basemodule.NavController3Impl
import com.example.basemodule.NavModuleKey
import com.example.homemodule.homeModuleEntryProvider
import com.example.navigation3.ui.theme.Navigation3Theme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Navigation3Theme {
                val backStack = rememberNavBackStack(AuthNavModule.SplashScreen)
                CompositionLocalProvider(
                    LocalNavController3 provides NavController3Impl(backStack)
                ) {

                    NavDisplay(
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
