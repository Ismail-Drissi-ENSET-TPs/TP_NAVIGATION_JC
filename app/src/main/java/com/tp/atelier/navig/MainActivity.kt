package com.tp.atelier.navig

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tp.atelier.navig.components.AppBottomBar
import com.tp.atelier.navig.components.AppTopBar
import com.tp.atelier.navig.navigation.NavDestination
import com.tp.atelier.navig.screens.*
import com.tp.atelier.navig.ui.theme.MultiScreensTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MultiScreensTheme {
                AppContent()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent() {
    val navController = rememberNavController()

    fun navigateToBottomBarRoute(route: String) {
        navController.navigate(route) {
            popUpTo(NavDestination.Home.route) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    fun navigateHome() {
        navController.navigate(NavDestination.Home.route) {
            popUpTo(NavDestination.Home.route) {
                inclusive = true
            }
        }
    }

    fun navigateToScreen(route: String) {
        navController.navigate(route) {
            launchSingleTop = true
        }
    }

    Scaffold(
        topBar = { 
            AppTopBar(
                onNavigateToHome = { navigateHome() }
            ) 
        },
        bottomBar = {
            AppBottomBar(
                onNavigateToHome = { navigateHome() },
                onNavigateToScreen2 = { 
                    navController.navigate(NavDestination.Screen2.route) {
                        popUpTo(NavDestination.Screen2.route) {
                            inclusive = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = NavDestination.Home.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(NavDestination.Home.route) {
                HomeScreen(
                    onNavigateToScreen1 = { navigateToScreen(NavDestination.Screen1.route) }
                )
            }
            composable(NavDestination.Screen1.route) {
                Screen1(
                    onNavigateToScreen2 = { navigateToScreen(NavDestination.Screen2.route) },
                    onNavigateBack = { navController.navigateUp() }
                )
            }
            composable(NavDestination.Screen2.route) {
                Screen2(
                    onNavigateToScreen3 = { navigateToScreen(NavDestination.Screen3.createRoute(42)) },
                    onNavigateBack = { navController.navigateUp() }
                )
            }
            composable(NavDestination.Screen3.route) { backStackEntry ->
                val value = backStackEntry.arguments?.getString("value")?.toIntOrNull() ?: 0
                Screen3(
                    value = value,
                    onNavigateBack = { navController.navigateUp() }
                )
            }
        }
    }
}