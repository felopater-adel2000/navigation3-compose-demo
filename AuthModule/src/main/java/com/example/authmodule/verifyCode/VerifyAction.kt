package com.example.authmodule.verifyCode

sealed interface VerifyAction {

    class InitScreen(val phone: String) : VerifyAction
    object onSendCode: VerifyAction

}