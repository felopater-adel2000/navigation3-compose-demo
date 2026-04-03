package com.example.authmodule.login

sealed interface LoginAction {

    class OnPhoneNumberChanged(val phoneNumber: String) : LoginAction

    object OnLoginClicked : LoginAction

}