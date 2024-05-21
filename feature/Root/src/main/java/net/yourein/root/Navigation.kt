package net.yourein.root

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import net.yourein.home.ui.HomeRoot
import net.yourein.home.ui.lists.AuthorsScreen
import net.yourein.home.ui.lists.BooksScreen
import net.yourein.home.ui.lists.SeriesScreen
import net.yourein.home.ui.lists.TagsScreen
import net.yourein.library.ui.LibraryRoot
import net.yourein.librocore.LibroNavigator
import net.yourein.search.ui.SearchRoot

/*
Screenのモデリングミスった感じある
もともとはBottomNavigationだけで使う予定だったけどこれをNavigationで使うようにするなら
FilledIconはnullableにしたほうがいい気がする
 */
sealed class Screen(val route: String, val FilledIcon: ImageVector) {
    object HomeGroup: Screen("Home", Icons.Filled.Home)
    object Home: Screen("HomeRoot", Icons.Filled.Home)
    object Search: Screen("Search", Icons.Filled.Search)
    object Add: Screen("Add", Icons.Filled.Add)
    object Books: Screen("Books", Icons.Filled.Add)
    object Authors: Screen("Authors", Icons.Filled.Add)
    object Series: Screen("Series", Icons.Filled.Add)
    object Tags: Screen("Tags", Icons.Filled.Add)
}

fun NavGraphBuilder.homeGroup() =
    navigation(startDestination = Screen.Home.route, route = Screen.HomeGroup.route) {
        homeScreen()
        booksScreen()
        authorsScreen()
        seriesScreen()
        tagsScreen()
    }

fun NavGraphBuilder.homeScreen() =
    composable(Screen.Home.route) { HomeRoot() }

fun NavGraphBuilder.searchScreen() =
    composable(Screen.Search.route) { SearchRoot() }

fun NavGraphBuilder.addScreen() =
    composable(Screen.Add.route) { LibraryRoot() }

fun NavGraphBuilder.booksScreen() =
    composable(Screen.Books.route) { BooksScreen() }

fun NavGraphBuilder.authorsScreen() =
    composable(Screen.Authors.route) { AuthorsScreen() }

fun NavGraphBuilder.seriesScreen() =
    composable(Screen.Series.route) { SeriesScreen() }

fun NavGraphBuilder.tagsScreen() =
    composable(Screen.Tags.route) { TagsScreen() }

class LibroNavigatorImplementation(private val navController: NavHostController): LibroNavigator {
    override fun findNavController(): NavHostController {
        return navController
    }

    override fun navigateToHome(navOptions: NavOptions?) =
        navController.navigate(Screen.HomeGroup.route, navOptions)

    override fun navigateToSearch(navOptions: NavOptions?) =
        navController.navigate(Screen.Search.route, navOptions)

    override fun navigateToAdd(navOptions: NavOptions?) =
        navController.navigate(Screen.Add.route, navOptions)

    override fun navigateToBooks(navOptions: NavOptions?) =
        navController.navigate(Screen.Books.route, navOptions)

    override fun navigateToAuthors(navOptions: NavOptions?) =
        navController.navigate(Screen.Authors.route, navOptions)

    override fun navigateToSeries(navOptions: NavOptions?) =
        navController.navigate(Screen.Series.route, navOptions)

    override fun navigateToTags(navOptions: NavOptions?) =
        navController.navigate(Screen.Tags.route, navOptions)
}