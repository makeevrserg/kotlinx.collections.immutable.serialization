package ru.astrainteractive.klibs.kotlinx.collections.immutable

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.ImmutableSet
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.PersistentSet
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.persistentSetOf
import kotlinx.serialization.Serializable
import ru.astrainteractive.klibs.kotlinx.collections.immutable.util.JsonConfigurationFactory
import ru.astrainteractive.klibs.kotlinx.collections.immutable.util.JsonExt.encodeAndDecode
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class ImmutableCollectionSerializerTest {

    @Serializable
    private class ImmutableListHolder<T>(
        @Serializable(with = ImmutableListSerializer::class)
        val immutableList: ImmutableList<T>
    )

    @Test
    fun testImmutableList() {
        val json = JsonConfigurationFactory.createJsonConfiguration()
        persistentListOf(1, 2, 3)
            .let(::ImmutableListHolder)
            .let { expectedList ->
                assertContentEquals(
                    expected = expectedList.immutableList,
                    actual = json.encodeAndDecode(expectedList).immutableList
                )
            }
    }

    @Serializable
    private class PersistentListHolder<T>(
        @Serializable(with = PersistentListSerializer::class)
        val persistentList: PersistentList<T>
    )

    @Test
    fun testPersistentList() {
        val json = JsonConfigurationFactory.createJsonConfiguration()
        persistentListOf(1, 2, 3)
            .let(::PersistentListHolder)
            .let { expectedList ->
                assertContentEquals(
                    expected = expectedList.persistentList,
                    actual = json.encodeAndDecode(expectedList).persistentList
                )
            }
    }

    @Serializable
    private class ImmutableSetHolder<T>(
        @Serializable(with = ImmutableSetSerializer::class)
        val immutableSet: ImmutableSet<T>
    )

    @Test
    fun testImmutableSet() {
        val json = JsonConfigurationFactory.createJsonConfiguration()
        persistentSetOf(1, 2, 3)
            .let(::ImmutableSetHolder)
            .let { expectedSet ->
                assertEquals(
                    expected = expectedSet.immutableSet,
                    actual = json.encodeAndDecode(expectedSet).immutableSet
                )
            }
    }

    @Serializable
    private class PersistentSetHolder<T>(
        @Serializable(with = PersistentSetSerializer::class)
        val persistentSet: PersistentSet<T>
    )

    @Test
    fun testPersistentSet() {
        val json = JsonConfigurationFactory.createJsonConfiguration()
        persistentSetOf(1, 2, 3)
            .let(::PersistentSetHolder)
            .let { expectedSet ->
                assertEquals(
                    expected = expectedSet.persistentSet,
                    actual = json.encodeAndDecode(expectedSet).persistentSet
                )
            }
    }

    @Serializable
    private class PersistentHashSetHolder<T>(
        @Serializable(with = PersistentHashSetSerializer::class)
        val persistentHashSet: PersistentSet<T>
    )

    @Test
    fun testPersistentHashSet() {
        val json = JsonConfigurationFactory.createJsonConfiguration()
        persistentSetOf(1, 2, 3)
            .let(::PersistentHashSetHolder)
            .let { expectedSet ->
                assertEquals(
                    expected = expectedSet.persistentHashSet,
                    actual = json.encodeAndDecode(expectedSet).persistentHashSet
                )
            }
    }
}
