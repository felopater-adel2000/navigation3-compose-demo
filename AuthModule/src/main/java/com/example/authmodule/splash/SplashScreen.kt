package com.example.authmodule.splash

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.basemodule.base.BaseScreen
import com.example.basemodule.navigation.LocalNav3Controller
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = koinViewModel()
) {
    BaseScreen(viewModel) {
        val viewState by viewModel.viewState.collectAsState()
        SplashContent(
            viewState = viewState,
            onAction = viewModel::onAction
        )
    }
}


@Composable
private fun SplashContent(
    viewState: SplashViewState,
    onAction: (SplashAction) -> Unit
) {

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ) {

            Text(text = "Splash Screen")

            Button(
                onClick = { onAction(SplashAction.OnLoginClicked) }
            ) {
                Text(text = "Go to Login")
            }

            Button(
                onClick = { onAction(SplashAction.OnVisitsClicked) }
            ) {
                Text(text = "Go to Visits")
            }

        }
    }

}



