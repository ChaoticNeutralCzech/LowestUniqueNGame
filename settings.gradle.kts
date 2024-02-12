pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        maven { url = uri("https://dl.bintray.com/kotlin/ktor") }
        maven { url = uri("https://www.jitpack.io") }
        google()
        mavenCentral()
    }
}
rootProject.name = "Lowest Unique N Game"
include(":app")
