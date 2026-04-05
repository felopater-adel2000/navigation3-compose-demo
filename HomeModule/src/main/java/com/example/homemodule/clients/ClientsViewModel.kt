package com.example.homemodule.clients

import com.example.basemodule.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ClientsViewModel : BaseViewModel() {

    private val _viewState = MutableStateFlow(ClientsViewState())
    val viewState = _viewState.asStateFlow()

    fun onAction(action: ClientsAction) {
        when (action) {

            else -> {}
        }
    }
}