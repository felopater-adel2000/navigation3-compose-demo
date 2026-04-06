package com.example.basemodule.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.basemodule.base.BaseViewModel

@Composable
fun Nav3ControllerEventHandler(
    viewModel: BaseViewModel,
    navController: Nav3Controller
) {
    LaunchedEffect(viewModel.screenDirectionEvent) {
        viewModel.screenDirectionEvent.collect { direction ->
            direction?.execute(navController)
        }
    }
}