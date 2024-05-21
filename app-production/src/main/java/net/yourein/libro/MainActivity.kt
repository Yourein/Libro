package net.yourein.libro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import net.yourein.librocore.LocalNavigationController
import net.yourein.librocore.theme.LibroTheme
import net.yourein.root.LibroNavigatorImplementation
import net.yourein.root.MainRoot

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val libroNavigator = LibroNavigatorImplementation(navController)
            LibroTheme {
                // A surface container using the 'background' color from the theme
                CompositionLocalProvider(LocalNavigationController provides libroNavigator) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        MainRoot(
                            navigator = libroNavigator
                        )
                    }
                }
            }
        }
    }
}