package com.example.authmodule.verifyCode

import com.example.basemodule.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class VerifyViewModel : BaseViewModel() {
    private val _viewState = MutableStateFlow(VerifyViewState())
    val viewState = _viewState.asStateFlow()

    fun onAction(action: VerifyAction) {
        when (action) {
            VerifyAction.onSendCode -> navigateToHome()
        }
    }

        private fun navigateToHome() {
            emitScreenDirection(VerifyDirection.NavigateToHome)
        }
}