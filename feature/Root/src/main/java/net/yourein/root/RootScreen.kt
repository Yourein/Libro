package net.yourein.root

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navOptions


@Composable
fun MainRoot(
    navController: NavHostController
) {
    Scaffold(
        bottomBar = {
            NavigationBar (
                contentColor = Color(0xFFE0E0E0),
            ) {
                val defaultNavOptions = navOptions {
                    popUpTo(Screen.Home.route) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                NavigationBarItem(
                    selected = currentDestination?.hierarchy?.any { it.route == Screen.Home.route } == true,
                    onClick = { navController.navigateToHome(defaultNavOptions) },
                    icon = { NavigationIcon(Screen.Home) }
                )

                NavigationBarItem(
                    selected = currentDestination?.hierarchy?.any { it.route == Screen.Search.route } == true,
                    onClick = { navController.navigateToSearch(defaultNavOptions) },
                    icon = { NavigationIcon(Screen.Search) }
                )

                NavigationBarItem(
                    selected = currentDestination?.hierarchy?.any { it.route == Screen.Add.route } == true,
                    onClick = { navController.navigateToAdd(defaultNavOptions) },
                    icon = { NavigationIcon(Screen.Add) }
                )
            }
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = Screen.Home.route, Modifier.padding(innerPadding)) {
            homeScreen()
            searchScreen()
            addScreen()
        }
    }
}

@Composable
private fun NavigationIcon(route: Screen) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            route.FilledIcon,
            contentDescription = null,
        )
        Text(
            route.route,
            fontSize = 11.sp,
        )
    }
}