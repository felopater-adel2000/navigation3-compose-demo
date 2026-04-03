package com.example.authmodule.verifyCode

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
import com.example.authmodule.a_navigation.AuthNavModule
import com.example.basemodule.base.BaseScreen
import com.example.basemodule.navigation.LocalNav3Controller
import org.koin.androidx.compose.koinViewModel


@Composable
fun VerifyCodeScreen(
    args: AuthNavModule.VerifyCodeScreen,
    viewModel: VerifyViewModel = koinViewModel()
) {

    BaseScreen(viewModel) {
        val viewState by viewModel.viewState.collectAsState()
        VerifyCodeContent(
            viewState = viewState,
            onAction = viewModel::onAction
        )
    }
}

@Composable
fun VerifyCodeContent(
    viewState: VerifyViewState,
    onAction: (VerifyAction) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ) {

            Text(text = "Verif Code Screen with Mobile: ${viewState.phone}")

            Button(onClick = {
                onAction(VerifyAction.onSendCode)
            }) {
                Text(text = "Go to Home")
            }

        }
    }
}