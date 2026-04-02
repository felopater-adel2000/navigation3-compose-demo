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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.example.navigation3.ui.theme.Navigation3Theme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Navigation3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Serializable
data object Home : NavKey

@Serializable
data class Details(val id: Int) : NavKey

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    val backstack = remember { mutableStateListOf<NavKey>(Home) }

    NavDisplay(
        backStack = backstack,
        onBack = { backstack.removeLastOrNull() },
        entryProvider = entryProvider<NavKey> {

            entry<Home> {
                Text("Home")
            }

            entry<Details> {
                Text("Details for id: ${(it as Details).id}")
            }

        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Navigation3Theme {
        Greeting("Android")
    }
}