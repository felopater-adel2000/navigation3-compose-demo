package com.example.basemodule.navigation

import android.os.Bundle
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey

class Nav3BuilderOptions(
    private val backStack: NavBackStack<NavKey>,
    private val resultManager: NavResultManager
) {

    fun setResult(key: String, builder: Bundle.() -> Unit) {
        resultManager.setResult(key, builder)

    }

    fun popUpTo(navKeyClass: Class<out NavKey>, inclusive: Boolean = false) {
        if (navKeyClass.isInterface) popupToInterface(navKeyClass, inclusive)
        else popupToClass(navKeyClass, inclusive)
    }

    private fun popupToClass(navKeyClass: Class<out NavKey>, inclusive: Boolean) {
        var lastIndex = backStack.lastIndex

        while (lastIndex >= 0) {
            val entry = backStack[lastIndex]
            if (navKeyClass.isInstance(entry)) {
                // Found the target class
                if (inclusive) backStack.removeLastOrNull()
                break
            } else {

                backStack.removeLastOrNull()
            }
            lastIndex--
        }
    }

    private fun popupToInterface(navKeyClass: Class<out NavKey>, inclusive: Boolean) {
        var lastIndex = backStack.lastIndex

        var foundImplementation = false
        var firstImplementationIndex = -1

        for (i in 0..backStack.lastIndex) {
            if (navKeyClass.isInstance(backStack[i])) {
                firstImplementationIndex = i
                break
            }
        }
        while (lastIndex >= 0) {
            val entry = backStack[lastIndex]

            if (navKeyClass.isInstance(entry)) {
                foundImplementation = true

                if (!inclusive && lastIndex == firstImplementationIndex) break
                backStack.removeLastOrNull()
            } else if (foundImplementation) {
                // Already found and removed all implementing classes
                break
            }
            lastIndex--
        }
    }

}