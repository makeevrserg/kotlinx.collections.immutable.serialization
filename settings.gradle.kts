pluginManagement {
    repositories {
        google()
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenLocal()
        mavenCentral()
    }
}

// Project info
rootProject.name = "kotlinx.collections.immutable.serialization"

// Subprojects
include(":serialization")
