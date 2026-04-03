package com.example.authmodule.splash

import com.example.basemodule.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.koin.core.annotation.KoinViewModel

@KoinViewModel
class SplashViewModel : BaseViewModel() {

    private val _viewState = MutableStateFlow(SplashViewState())
    val viewState = _viewState.asStateFlow()

    fun onAction(action: SplashAction) {
        when (action) {
            SplashAction.OnLoginClicked -> navigateToLogin()

            SplashAction.OnVisitsClicked -> navigateToVisits()
        }
    }

    private fun navigateToVisits() {
        emitScreenDirection(SplashDirections.NavigateToVisits)
    }

    private fun navigateToLogin() {
        emitScreenDirection(SplashDirections.NavigateToLogin)
    }

}