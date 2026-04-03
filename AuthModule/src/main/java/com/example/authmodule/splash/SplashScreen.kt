package com.example.authmodule.splash

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.authmodule.AuthNavModule
import com.example.basemodule.LocalNavController3

@Composable
fun SplashScreen() {

    val navController = LocalNavController3.current

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ) {

            Text(text = "Splash Screen")

            Button(onClick = {
                // Navigate to the next screen, e.g., LoginScreen
                navController.navigate("com.example.authmodule.AuthNavModule\$LoginScreen")
            }) {
                Text(text = "Go to Login")
            }

        }
    }

}