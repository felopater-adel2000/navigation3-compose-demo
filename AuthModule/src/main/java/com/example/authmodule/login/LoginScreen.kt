package com.example.authmodule.login

import android.R.attr.phoneNumber
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.basemodule.base.BaseScreen
import com.example.basemodule.navigation.LocalNav3Controller
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = koinViewModel()
) {
    BaseScreen(
        viewModel = viewModel,
        onCreate = {

        }
    ) {
        val viewState by viewModel.viewState.collectAsState()
        LoginContent(
            viewState = viewState,
            onAction = { viewModel.onAction(it) }
        )
    }
}

@Composable
private fun LoginContent(
    viewState: LoginViewState,
    onAction: (LoginAction) -> Unit
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

            Text(text = "Login Screen")


            TextField(
                modifier = Modifier.padding(16.dp),
                value = viewState.phoneNumber,
                onValueChange = { onAction(LoginAction.OnPhoneNumberChanged(it)) },
            )


            Button(onClick = {
                onAction(LoginAction.OnLoginClicked)
            }) {
                Text(text = "Go to Verify Code")
            }

        }
    }

}