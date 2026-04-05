package com.example.homemodule.profile

import com.example.basemodule.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProfileViewModel : BaseViewModel() {

    private val _viewState = MutableStateFlow(ProfileViewState())
    val viewState = _viewState.asStateFlow()

    fun onAction(action: ProfileAction) {
        when (action) {

            else -> {}
        }
    }

}