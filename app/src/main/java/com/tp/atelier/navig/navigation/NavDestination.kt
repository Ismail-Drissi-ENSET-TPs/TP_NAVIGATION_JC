package com.tp.atelier.navig.navigation

sealed class NavDestination(val route: String) {
    object Home : NavDestination("home")
    object Screen1 : NavDestination("screen1")
    object Screen2 : NavDestination("screen2")
    object Screen3 : NavDestination("screen3/{value}") {
        fun createRoute(value: Int) = "screen3/$value"
    }
}
