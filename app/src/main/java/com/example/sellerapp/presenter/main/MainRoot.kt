package com.example.sellerapp.presenter.main
import androidx.activity.compose.BackHandler
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sellerapp.core.navigation.AppNavigationProvider
import com.example.sellerapp.presenter.NavGraphs
import com.example.sellerapp.ui.theme.SellerAppTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.dependency

@Composable
fun MainRoot(finish: () -> Unit) {
    val navController = rememberNavController()

    val currentBackStackEntryAsState by navController.currentBackStackEntryAsState()
    val destination = currentBackStackEntryAsState?.destination?.route
        ?: NavGraphs.root.startRoute.route

    if(destination == NavGraphs.root.startRoute.route) {
        BackHandler {
            finish()
        }
    }

    SellerAppTheme {
        Surface {
            DestinationsNavHost(
                navController = navController,
                navGraph = NavGraphs.root,
                dependenciesContainerBuilder = {
                    dependency(AppNavigationProvider(navController))
                }
            )
        }
    }
    
}