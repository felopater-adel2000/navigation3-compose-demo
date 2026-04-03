package com.example.authmodule.verifyCode

sealed interface VerifyAction {

    object onSendCode: VerifyAction

}