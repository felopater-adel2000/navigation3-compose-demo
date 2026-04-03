package com.example.homemodule.visits

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.basemodule.DeepLinkConstant
import com.example.basemodule.navigation.LocalNav3Controller
import com.example.basemodule.navigation.NavModuleKey

@Composable
fun VisitsScreen() {

    val navController = LocalNav3Controller.current

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ) {

            Text(text = "Visits Screen")

            Button(onClick = {
                // Navigate to the next screen, e.g., LoginScreen
                navController.navigate(DeepLinkConstant.LOGIN_SCREEN) {
                        popUpTo(NavModuleKey::class.java, inclusive = true)
                }
            }) {
                Text(text = "Logout")
            }

        }
    }


}