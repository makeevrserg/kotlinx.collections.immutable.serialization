package ru.astrainteractive.klibs.kotlinx.collections.immutable.util


import kotlinx.serialization.json.Json

internal object JsonConfigurationFactory {
    fun createJsonConfiguration() = Json {
        isLenient = false
        prettyPrint = true
        ignoreUnknownKeys = false
    }
}