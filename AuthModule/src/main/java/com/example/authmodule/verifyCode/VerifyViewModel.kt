package com.example.authmodule.verifyCode

import com.example.basemodule.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class VerifyViewModel : BaseViewModel() {
    private val _viewState = MutableStateFlow(VerifyViewState())
    val viewState = _viewState.asStateFlow()

    fun onAction(action: VerifyAction) {
        when (action) {
            VerifyAction.onSendCode -> navigateToHome()

            is VerifyAction.InitScreen -> initScreen(action.phone)

            VerifyAction.OnErrorOTP -> navigateBackWithError()
        }
    }

    private fun initScreen(phoneNumber: String) {
        _viewState.update {
            it.copy(
                phone = phoneNumber
            )
        }
    }

    private fun navigateToHome() {
        emitScreenDirection(VerifyDirection.NavigateToHome)
    }

    private fun navigateBackWithError() {
        emitScreenDirection(VerifyDirection.NavigateBackWithError("OTP is not correct"))
    }
}