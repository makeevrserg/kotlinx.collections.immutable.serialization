package ru.astrainteractive.klibs.kotlinx.collections.immutable.util

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object JsonExt {
    inline fun <reified T> Json.encodeAndDecode(value: T): T {
        val string = encodeToString(value)
        return decodeFromString(string)
    }
}