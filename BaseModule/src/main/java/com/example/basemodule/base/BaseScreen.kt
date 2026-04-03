package com.example.basemodule.base

import androidx.compose.runtime.Composable
import com.example.basemodule.navigation.Nav2ControllerEventHandler

@Composable
fun BaseScreen(
    viewModel: BaseViewModel,
    content: @Composable () -> Unit
) {
    Nav2ControllerEventHandler(viewModel = viewModel)
    content()
}