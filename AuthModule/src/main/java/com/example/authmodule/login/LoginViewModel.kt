package com.example.authmodule.login

import com.example.basemodule.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel : BaseViewModel() {

    private val _viewState = MutableStateFlow(LoginViewState())
    val viewState = _viewState.asStateFlow()

    fun onAction(action: LoginAction) {
        when (action) {
            is LoginAction.OnPhoneNumberChanged -> {
                _viewState.value = _viewState.value.copy(phoneNumber = action.phoneNumber)
            }
            LoginAction.OnLoginClicked -> {
                val phoneNumber = _viewState.value.phoneNumber
                if (phoneNumber.isNotBlank()) {
                    emitScreenDirection(LoginDirection.NavigateToVerification(phoneNumber))
                }
            }
        }
    }
}