package com.example.basemodule.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basemodule.navigation.ScreenDirection
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class BaseViewModel : ViewModel() {

    private val _screenDirectionEvent = MutableSharedFlow<ScreenDirection?>()
    val screenDirectionEvent = _screenDirectionEvent.asSharedFlow()


    fun emitScreenDirection(direction: ScreenDirection) {
        viewModelScope.launch {
            _screenDirectionEvent.emit(direction)
        }
    }

}