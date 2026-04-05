package com.example.homemodule.visits

import com.example.basemodule.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class VisitsViewModel : BaseViewModel() {

    private val _viewState = MutableStateFlow(VisitsViewState())
    val viewState = _viewState.asStateFlow()

    fun onAction(action: VisitsAction) {
        when (action) {

            else -> {}
        }
    }

}