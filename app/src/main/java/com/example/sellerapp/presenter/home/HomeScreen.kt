package com.example.sellerapp.presenter.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.sellerapp.R
import com.example.sellerapp.core.navigation.NavigationProvider
import com.example.sellerapp.presenter.NavGraphs
import com.example.sellerapp.presenter.appCurrentDestinationAsState
import com.example.sellerapp.presenter.destinations.BarCodeScreenDestination
import com.example.sellerapp.presenter.destinations.ProfileScreenDestination
import com.example.sellerapp.presenter.destinations.QRCodeScreenDestination
import com.example.sellerapp.presenter.startAppDestination
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.dependency
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec
import com.example.sellerapp.presenter.destinations.Destination as HomeDestination

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun HomeScreen(
    navigator: NavigationProvider
) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigation(navController) }) {
        NavigationGraph(
            navController = navController,
            navigator = navigator,
            innerPadding = it
        )
    }
}

@Composable
fun NavigationGraph(
    navController: NavHostController,
    navigator: NavigationProvider,
    innerPadding: PaddingValues
) {
    DestinationsNavHost(
        navController = navController,
        navGraph = NavGraphs.home,
        dependenciesContainerBuilder = {
            dependency(navigator)
        }
    )
}


@Composable
fun BottomNavigation(navController: NavController) {

    androidx.compose.material.BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Black
    ) {
        val currentDestination: HomeDestination? =
            navController.appCurrentDestinationAsState().value
                ?: NavGraphs.home.startAppDestination

        BottomBarDestination.values().forEach { destination ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = destination.icon),
                        contentDescription = destination.label
                    )
                },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentDestination == destination.direction,
                onClick = {
                    navController.navigate(destination.direction) {
                        popUpTo(navController.graph.id)
                    }
                }
            )
        }
    }
}

enum class BottomBarDestination(
    val direction: DirectionDestinationSpec,
    val icon: Int,
    val label: String
) {
    Barcode(BarCodeScreenDestination, R.drawable.home_bottom_nav, "bar_code"),
    QRCode(QRCodeScreenDestination, R.drawable.barcode_botton_nav, "qr code"),
    Profile(ProfileScreenDestination, R.drawable.profile_bottom_nav, "profile"),
}