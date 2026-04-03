package com.example.authmodule.splash

sealed interface SplashAction {

    object OnLoginClicked : SplashAction

    object OnVisitsClicked : SplashAction

}