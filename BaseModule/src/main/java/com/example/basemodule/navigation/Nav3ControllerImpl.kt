package com.example.basemodule.navigation

import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey

class Nav3ControllerImpl(private val backStack: NavBackStack<NavKey>) : Nav3Controller {

    override fun navigate(key: NavModuleKey, optionsBuilder: (Nav3BuilderOptions.() -> Unit)?) {
        optionsBuilder?.let {
            val builderOptions = Nav3BuilderOptions(backStack)
            it(builderOptions)
        }
        backStack.add(key)
    }

    override fun navigate(keyName: String, vararg args: Any, optionsBuilder: (Nav3BuilderOptions.() -> Unit)?) {
        optionsBuilder?.let {
            val builderOptions = Nav3BuilderOptions(backStack)
            it(builderOptions)
        }
        val instance: NavModuleKey = NavModuleKey.createInstance(keyName, *args)
        backStack.add(instance)
    }

    override fun popBackStack() {
        backStack.removeLastOrNull()
    }

    override fun clearBackStack() {
        backStack.clear()
    }
}