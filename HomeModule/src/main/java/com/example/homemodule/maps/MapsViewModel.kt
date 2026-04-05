package com.example.homemodule.maps

import com.example.basemodule.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MapsViewModel : BaseViewModel() {
    private val _viewState = MutableStateFlow(MapsViewState())
    val viewState = _viewState.asStateFlow()

    fun onAction(action: MapsAction) {
        when (action) {

            else -> {}
        }
    }
}