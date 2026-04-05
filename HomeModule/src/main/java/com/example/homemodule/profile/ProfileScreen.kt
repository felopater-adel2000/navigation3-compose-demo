package com.example.homemodule.profile

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.basemodule.base.BaseScreen
import org.koin.androidx.compose.koinViewModel


@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = koinViewModel()
) {

    BaseScreen(viewModel) {
        val viewState = viewModel.viewState.collectAsState().value

        ProfileScreenContent(
            viewState = viewState,
            onAction = viewModel::onAction
        )
    }

}

@Composable
private fun ProfileScreenContent(
    viewState: ProfileViewState,
    onAction: (ProfileAction) -> Unit,
) {

     androidx.compose.material3.Scaffold(
        modifier = androidx.compose.ui.Modifier.fillMaxSize(),
    ) { paddingValues ->
        androidx.compose.foundation.layout.Column(
            modifier = androidx.compose.ui.Modifier.fillMaxSize().padding(paddingValues),
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ) {

            androidx.compose.material3.Text(text = "Profile Screen")

        }
    }
}