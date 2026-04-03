package com.example.basemodule.navigation

import android.util.Log
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey

class Nav3BuilderOptions(private val backStack: NavBackStack<NavKey>) {

    fun popUpTo(navKeyClass: Class<out NavKey>, inclusive: Boolean = false) {
        Log.d("TAG", "popupTo: navKeyClass: ${navKeyClass.name}, inclusive: $inclusive")

        // Check if navKeyClass is an interface
        if (navKeyClass.isInterface) {
            Log.d("TAG", "popupTo: navKeyClass is an interface - removing all implementing classes")
            popupToInterface(navKeyClass, inclusive)
        } else {
            Log.d("TAG", "popupTo: navKeyClass is a normal class - removing until target class")
            popupToClass(navKeyClass, inclusive)
        }
    }

    /**
     * Algorithm for normal classes:
     * Remove last element in backstack until reaching the target class,
     * and remove it based on inclusive parameter.
     */
    private fun popupToClass(navKeyClass: Class<out NavKey>, inclusive: Boolean) {
        var lastIndex = backStack.lastIndex
        Log.d("TAG", "popupToClass: lastIndex: $lastIndex")

        while (lastIndex >= 0) {
            val entry = backStack[lastIndex]

            if (navKeyClass.isInstance(entry)) {
                // Found the target class
                if (inclusive) {
                    backStack.removeLastOrNull()
                    Log.d("TAG", "popupToClass: inclusive=true - removed target entry: $entry")
                }
                break
            } else {
                // Not the target class, remove it
                backStack.removeLastOrNull()
                Log.d("TAG", "popupToClass: removed entry: $entry")
            }

            lastIndex--
            Log.d("TAG", "popupToClass: backStack size: ${backStack.size}")
        }
    }

    /**
     * Algorithm for interfaces:
     * Remove all classes from the backstack that implement the specified interface,
     * starting from the last element. If inclusive is false, keep the first (oldest)
     * implementation in the backstack.
     */
    private fun popupToInterface(navKeyClass: Class<out NavKey>, inclusive: Boolean) {
        var lastIndex = backStack.lastIndex
        Log.d("TAG", "popupToInterface: lastIndex: $lastIndex, inclusive: $inclusive")

        var foundImplementation = false
        var firstImplementationIndex = -1

        // First pass: find the first (oldest) implementation index
        for (i in 0..backStack.lastIndex) {
            if (navKeyClass.isInstance(backStack[i])) {
                firstImplementationIndex = i
                break
            }
        }

        // Second pass: remove from last to first
        while (lastIndex >= 0) {
            val entry = backStack[lastIndex]

            if (navKeyClass.isInstance(entry)) {
                // This entry implements the interface
                foundImplementation = true

                // If not inclusive and this is the first implementation, keep it
                if (!inclusive && lastIndex == firstImplementationIndex) {
                    break
                }

                backStack.removeLastOrNull()
                Log.d("TAG", "popupToInterface: removed implementing entry: $entry")
            } else if (foundImplementation) {
                // Already found and removed all implementing classes
                break
            }

            lastIndex--
            Log.d("TAG", "popupToInterface: backStack size: ${backStack.size}")
        }

        Log.d("TAG", "popupToInterface: completed, foundImplementation: $foundImplementation")
    }

}