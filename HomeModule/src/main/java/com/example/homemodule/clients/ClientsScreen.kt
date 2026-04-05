package com.example.homemodule.clients

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.basemodule.base.BaseScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun ClientsScreen(
    viewModel: ClientsViewModel = koinViewModel()
) {
    BaseScreen(viewModel) {
        val viewState by viewModel.viewState.collectAsState()

        ClientsScreenContent(
            viewState = viewState,
            onAction = viewModel::onAction
        )
    }
}

@Composable
private fun ClientsScreenContent(
    viewState: ClientsViewState,
    onAction: (ClientsAction) -> Unit,
) {

    Scaffold(
        modifier = androidx.compose.ui.Modifier.fillMaxSize(),
    ) { paddingValues ->
        Column(
            modifier = androidx.compose.ui.Modifier.fillMaxSize().padding(paddingValues),
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ) {


            Text(text = "Clients Screen")

        }
    }
}