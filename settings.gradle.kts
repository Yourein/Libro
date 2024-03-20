pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Libro"
include(":app-production")
include(":app-development")
include(":feature:Home")
include(":feature:Search")
include(":feature:Library")
include(":feature:DataSource")
include(":feature:Root")
include(":LibroUI")
