package com.example.basemodule.base

import androidx.compose.runtime.Composable
import com.example.basemodule.navigation.Nav3ControllerEventHandler

@Composable
fun BaseScreen(
    viewModel: BaseViewModel,
    content: @Composable () -> Unit
) {
    Nav3ControllerEventHandler(viewModel = viewModel)
    content()
}