package net.yourein.librocore

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions

val LocalNavigationController = staticCompositionLocalOf<LibroNavigator> {
    error("NavController is not initialized")
}

interface LibroNavigator {
    fun findNavController(): NavHostController

    fun navigateToHome(navOptions: NavOptions?)
    fun navigateToSearch(navOptions: NavOptions?)
    fun navigateToAdd(navOptions: NavOptions?)
    fun navigateToBooks(navOptions: NavOptions?)
    fun navigateToAuthors(navOptions: NavOptions?)
    fun navigateToSeries(navOptions: NavOptions?)
    fun navigateToTags(navOptions: NavOptions?)
}