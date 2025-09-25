
## 🚀 Installation

#### Version catalogs

```toml
[versions]
klibs-immutableserialization = "<latest-version>"

[libraries]
klibs-immutableserialization = { module = "ru.astrainteractive.klibs:kotlinx.collections.immutable.serialization", version.ref = "klibs-immutableserialization" }
```

#### Gradle

```kotlin
implementation("ru.astrainteractive.klibs:kotlinx.collections.immutable.serialization:<version>")
// or version catalogs
implementation(libs.klibs.immutableserialization)
```


### Usage

Serialization modules allows you to apply custom immutable collection serializers, for example:

```kotlin
@Serializable
private class MyCustomClass<K, V>(
    @Serializable(with = ImmutableMapSerializer::class)
    val immutableMap: ImmutableMap<K, V>
)
```

#### Collection Serializers

| Serializer                    | Conversion method       
|-------------------------------|------------------------- 
| `ImmutableListSerializer`     | `toImmutableList()`     | 
| `PersistentListSerializer`    | `toPersistentList()`    | 
| `ImmutableSetSerializer`      | `toImmutableSet()`      | 
| `PersistentSetSerializer`     | `toPersistentSet()`     | 
| `PersistentHashSetSerializer` | `toPersistentHashSet()` | 

#### Map Serializers

| Serializer                    | Conversion method       
|-------------------------------|------------------------- 
| `ImmutableMapSerializer`      | `toImmutableMap()`      | 
| `PersistentMapSerializer`     | `toPersistentMap()`     | 
| `PersistentHashMapSerializer` | `toPersistentHashMap()` | 

