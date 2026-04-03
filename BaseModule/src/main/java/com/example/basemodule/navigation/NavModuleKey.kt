package com.example.basemodule.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

interface NavModuleKey : NavKey {

    companion object {
        fun createInstance(keyName: String, vararg args: Any): NavModuleKey {
            val kClass = Class.forName(keyName).kotlin

            // ✅ Ensure class implements NavModuleKey
            if (!NavModuleKey::class.java.isAssignableFrom(kClass.java)) {
                throw IllegalArgumentException("Class $keyName is not a NavModuleKey")
            }

            val instance: NavModuleKey = when {
                // ✅ Case 1: data object / object
                kClass.objectInstance != null -> {
                    kClass.objectInstance as NavModuleKey
                }

                // ✅ Case 2: data class (constructor)
                else -> {
                    // Find the primary constructor (user-defined params only)
                    // kotlinx.serialization adds a synthetic constructor, so we need to find the one with user params
                    val primaryConstructor = kClass.constructors.find { constructor ->
                        constructor.parameters.none { param ->
                            param.name == "serializationConstructorMarker" ||
                                    param.name?.startsWith("seen") == true
                        }
                    } ?: kClass.constructors.firstOrNull()
                    ?: throw IllegalArgumentException("No constructor found for $keyName")

                    // Validate parameters count
                    if (primaryConstructor.parameters.size != args.size) {
                        throw IllegalArgumentException(
                            "Constructor of $keyName expects ${primaryConstructor.parameters.size} args (${primaryConstructor.parameters.map { it.name }}), but got ${args.size}"
                        )
                    }

                    try {
                        primaryConstructor.call(*args) as NavModuleKey
                    } catch (e: Exception) {
                        throw IllegalArgumentException(
                            "Failed to create instance of $keyName with args ${args.toList()}",
                            e
                        )
                    }
                }
            }

            return instance
        }
    }

}