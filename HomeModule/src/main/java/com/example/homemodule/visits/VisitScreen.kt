package com.example.homemodule.visits

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
import com.example.basemodule.DeepLinkConstant
import com.example.basemodule.base.BaseScreen
import com.example.basemodule.navigation.LocalNav3Controller
import com.example.basemodule.navigation.NavModuleKey

@Composable
fun VisitsScreen(
    viewModel: VisitsViewModel = org.koin.androidx.compose.koinViewModel()
) {
    BaseScreen(viewModel) {
        val viewState by viewModel.viewState.collectAsState()
        VisitsContent(
            viewState = viewState,
            onAction = viewModel::onAction
        )
    }
}

@Composable
private fun VisitsContent(
    viewState: VisitsViewState,
    onAction: (VisitsAction) -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ) {

            Text(text = "Visits Screen")

            Button(onClick = {

            }) {
                Text(text = "Logout")
            }

        }
    }
}