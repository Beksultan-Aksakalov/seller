package com.example.seller.presentation.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.seller.presentation.bottomNav.BottomNavItem
import com.example.seller.presentation.bottomNav.screen.BarCodeScreen
import com.example.seller.presentation.bottomNav.screen.ProfileScreen
import com.example.seller.presentation.bottomNav.screen.QRCodeScreen
import com.example.seller.presentation.bottomNav.screen.profile.ProfileInformation
import com.example.seller.route.Routes

@Composable
fun BaseScreen(navController: NavController) {
    val mnavController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigation(navController = mnavController) }
    ) { innerPadding ->
        NavigationGraph(navController = mnavController, innerPadding)
    }

}

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Barcode,
        BottomNavItem.QRCode,
        BottomNavItem.Profile,
    )
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController, innerPadding: PaddingValues) {
    NavHost(navController, startDestination = BottomNavItem.Barcode.screen_route) {
        composable(BottomNavItem.Barcode.screen_route) {
            BarCodeScreen()
        }
        composable(BottomNavItem.QRCode.screen_route) {
            QRCodeScreen()
        }
        composable(BottomNavItem.Profile.screen_route) {
            ProfileScreen(navController = navController)
        }
        composable(route = Routes.PROFILE_INFORMATION.name) {
            ProfileInformation(navController = navController)
        }
    }
}
