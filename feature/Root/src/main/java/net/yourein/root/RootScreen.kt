package net.yourein.root

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import net.yourein.home.ui.HomeRoot
import net.yourein.library.ui.LibraryRoot
import net.yourein.search.ui.SearchRoot

sealed class Screen(val route: String, val FilledIcon: ImageVector) {
    object Home: Screen("Home", Icons.Filled.Home)
    object Search: Screen("Search", Icons.Filled.Search)
    object Library: Screen("Library", Icons.Filled.Menu)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainRoot(
    navController: NavHostController
) {
    Scaffold(
        bottomBar = {
            BottomNavigation (
                contentColor = Color(0xFFE0E0E0),
                backgroundColor = Color(0xFF101010),
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                val items = listOf(Screen.Home, Screen.Search, Screen.Library)
                items.forEach {screen ->
                    BottomNavigationItem(
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                              navController.navigate(screen.route){
                                  popUpTo(navController.graph.findStartDestination().id) {
                                      saveState = true
                                  }
                                  launchSingleTop = true
                                  restoreState = true
                              }
                        },
                        icon = { Icon(screen.FilledIcon, contentDescription = null) }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = Screen.Home.route, Modifier.padding(innerPadding)) {
            composable(Screen.Home.route) { HomeRoot() }
            composable(Screen.Search.route) { SearchRoot() }
            composable(Screen.Library.route) { LibraryRoot() }
        }
    }
}