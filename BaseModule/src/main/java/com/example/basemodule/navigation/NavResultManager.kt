package com.example.basemodule.navigation

import android.os.Bundle
import androidx.compose.runtime.staticCompositionLocalOf

/**
 * Manages navigation results between screens.
 * This allows screens to pass data back when popping the backstack.
 */
class NavResultManager private constructor() {

    internal val results = mutableMapOf<String, Bundle>()

    fun setResult(key: String, builder: Bundle.() -> Unit) {
        val bundle = results.getOrPut(key) { Bundle() }
        bundle.apply(builder)
    }

    fun getResult(key: String): Bundle? {
        return results[key]
    }

    fun clearResults(key: String) {
        results.remove(key)
    }

    fun hasResult(key: String): Boolean {
        return results.containsKey(key) && results[key]?.isEmpty == false
    }


    companion object {
        @Volatile
        private var INSTANCE: NavResultManager? = null

        fun getInstance(): NavResultManager {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: NavResultManager().also { INSTANCE = it }
            }
        }
    }
}


