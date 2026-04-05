package com.example.basemodule.base

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.example.basemodule.navigation.Nav3ControllerEventHandler

@Composable
fun BaseScreen(
    viewModel: BaseViewModel,
    onCreate: () -> Unit = {},
    onStart: () -> Unit = {},
    onResume: () -> Unit = {},
    onPause: () -> Unit = {},
    onStop: () -> Unit = {},
    onDestroy: () -> Unit = {},
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    content: @Composable () -> Unit
) {
    Nav3ControllerEventHandler(viewModel = viewModel)

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_START -> {
                    onStart()
                }

                Lifecycle.Event.ON_PAUSE -> {
                    onPause()
                }

                Lifecycle.Event.ON_STOP -> {
                    onStop()
                }

                Lifecycle.Event.ON_RESUME -> {
                    onResume()
                }

                Lifecycle.Event.ON_CREATE -> {
                    onCreate()
                }

                Lifecycle.Event.ON_DESTROY -> {
                    onDestroy()
                }

                else -> Unit
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    content()
}