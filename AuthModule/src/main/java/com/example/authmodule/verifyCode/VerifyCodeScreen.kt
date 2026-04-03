package com.example.authmodule.verifyCode

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.authmodule.a_navigation.AuthNavModule
import com.example.basemodule.navigation.LocalNav3Controller


@Composable
fun VerifyCodeScreen(args: AuthNavModule.VerifyCodeScreen) {

    val navController = LocalNav3Controller.current

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ) {

            Text(text = "Verif Code Screen with Mobile: ${args.phoneNumber}")

            Button(onClick = {
                // Navigate to the next screen, e.g., LoginScreen
                navController.navigateWithDeepLink("com.example.homemodule.HomeNavModule\$VisitsScreen")
            }) {
                Text(text = "Go to Home")
            }

        }
    }

}