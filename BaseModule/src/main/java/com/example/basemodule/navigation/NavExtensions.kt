package com.example.basemodule.navigation

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember


@Composable
fun Nav3Controller.observeResult(
    resultKey: String,
    clearOnReceive: Boolean = true
): Bundle? {
    val resultManager = getResultManager()
    val result = remember(resultKey) {
        resultManager.getResult(resultKey)
    }

    if (clearOnReceive && result != null) {
        DisposableEffect(resultKey) {
            onDispose {
                resultManager.clearResults(resultKey)
            }
        }
    }

    return result
}

fun NavModuleKey.getResultKey(): String = this::class.java.name
