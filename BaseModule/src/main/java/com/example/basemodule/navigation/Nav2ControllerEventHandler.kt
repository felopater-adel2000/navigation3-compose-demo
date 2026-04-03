package com.example.basemodule.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.basemodule.base.BaseViewModel

@Composable
fun Nav2ControllerEventHandler(viewModel: BaseViewModel) {
    val navController = LocalNav3Controller.current
    LaunchedEffect(viewModel.screenDirectionEvent) {
        viewModel.screenDirectionEvent.collect { direction ->
            direction?.execute(navController)
        }
    }
}