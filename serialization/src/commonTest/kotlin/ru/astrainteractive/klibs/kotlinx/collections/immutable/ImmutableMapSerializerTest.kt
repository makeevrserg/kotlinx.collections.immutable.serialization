package ru.astrainteractive.klibs.kotlinx.collections.immutable

import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.PersistentMap
import kotlinx.collections.immutable.persistentMapOf
import kotlinx.serialization.Serializable
import ru.astrainteractive.klibs.kotlinx.collections.immutable.util.JsonConfigurationFactory
import ru.astrainteractive.klibs.kotlinx.collections.immutable.util.JsonExt.encodeAndDecode
import kotlin.test.Test
import kotlin.test.assertEquals

class ImmutableMapSerializerTest {

    @Serializable
    private class ImmutableMapHolder<K, V>(
        @Serializable(with = ImmutableMapSerializer::class)
        val immutableMap: ImmutableMap<K, V>
    )

    @Test
    fun testImmutableList() {
        val json = JsonConfigurationFactory.createJsonConfiguration()
        persistentMapOf(1 to 1, 2 to 2, 3 to 3)
            .let(::ImmutableMapHolder)
            .let { expectedList ->
                assertEquals(
                    expected = expectedList.immutableMap,
                    actual = json.encodeAndDecode(expectedList).immutableMap
                )
            }
    }

    @Serializable
    private class PersistentMapHolder<K, V>(
        @Serializable(with = PersistentMapSerializer::class)
        val persistentMap: PersistentMap<K, V>
    )

    @Test
    fun testPersistentMap() {
        val json = JsonConfigurationFactory.createJsonConfiguration()
        persistentMapOf(1 to 1, 2 to 2, 3 to 3)
            .let(::PersistentMapHolder)
            .let { expectedList ->
                assertEquals(
                    expected = expectedList.persistentMap,
                    actual = json.encodeAndDecode(expectedList).persistentMap
                )
            }
    }

    @Serializable
    private class PersistentHashMapHolder<K, V>(
        @Serializable(with = PersistentHashMapSerializer::class)
        val hashMap: PersistentMap<K, V>
    )

    @Test
    fun testPersistentHashMap() {
        val json = JsonConfigurationFactory.createJsonConfiguration()
        persistentMapOf(1 to 1, 2 to 2, 3 to 3)
            .let(::PersistentHashMapHolder)
            .let { expectedList ->
                assertEquals(
                    expected = expectedList.hashMap,
                    actual = json.encodeAndDecode(expectedList).hashMap
                )
            }
    }
}
