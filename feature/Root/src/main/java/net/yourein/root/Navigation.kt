package net.yourein.root

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import net.yourein.home.ui.HomeRoot
import net.yourein.library.ui.LibraryRoot
import net.yourein.search.ui.SearchRoot

sealed class Screen(val route: String, val FilledIcon: ImageVector) {
    object Home: Screen("Home", Icons.Filled.Home)
    object Search: Screen("Search", Icons.Filled.Search)
    object Add: Screen("Add", Icons.Filled.Add)
}

fun NavGraphBuilder.homeScreen() =
    composable(Screen.Home.route) { HomeRoot() }

fun NavGraphBuilder.searchScreen() =
    composable(Screen.Search.route) { SearchRoot() }

fun NavGraphBuilder.addScreen() =
    composable(Screen.Add.route) { LibraryRoot() }

fun NavController.navigateToHome(navOptions: NavOptions? = null) =
    this.navigate(Screen.Home.route, navOptions)

fun NavController.navigateToSearch(navOptions: NavOptions? = null) =
    this.navigate(Screen.Search.route, navOptions)

fun NavController.navigateToAdd(navOptions: NavOptions? = null) =
    this.navigate(Screen.Add.route, navOptions)