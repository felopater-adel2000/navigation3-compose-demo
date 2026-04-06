package com.example.basemodule.navigation

import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey

class Nav3ControllerImpl(
    private val backStack: NavBackStack<NavKey>,
    private val resultManager: NavResultManager = NavResultManager.getInstance()
) : Nav3Controller {

    override fun navigate(key: NavModuleKey, optionsBuilder: (Nav3BuilderOptions.() -> Unit)?) {
        optionsBuilder?.let {
            val builderOptions = Nav3BuilderOptions(backStack, resultManager)
            it(builderOptions)
        }
        backStack.add(key)
    }

    override fun navigate(keyName: String, vararg args: Any, optionsBuilder: (Nav3BuilderOptions.() -> Unit)?) {
        optionsBuilder?.let {
            val builderOptions = Nav3BuilderOptions(backStack, resultManager)
            it(builderOptions)
        }
        val instance: NavModuleKey = NavModuleKey.createInstance(keyName, *args)
        backStack.add(instance)
    }

    override fun popBackStack(optionsBuilder: (Nav3BuilderOptions.() -> Unit)?) {
        optionsBuilder?.let {
            val builderOptions = Nav3BuilderOptions(backStack, resultManager)
            it(builderOptions)
        }
        backStack.removeLastOrNull()
    }

    override fun clearBackStack() {
        backStack.clear()
    }

    override fun getResultManager(): NavResultManager {
        return resultManager
    }
}