package com.example.seller.route

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.seller.presentation.bottomNav.screen.profile.ProfileInformation
import com.example.seller.presentation.hoc.BackNavigation
import com.example.seller.presentation.screen.Authorization
import com.example.seller.presentation.screen.BaseScreen
import com.example.seller.presentation.screen.Registration
import com.example.seller.presentation.screen.RegistrationCrePinCode
import com.example.seller.presentation.screen.RegistrationPinCode
import com.example.seller.presentation.screen.SplashScreen
import com.example.seller.presentation.screen.onboarding.OnBoarding
import com.example.seller.presentation.screen.onboarding.OnBoardingViewModel

@Composable
fun AppRoute() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.SPLASH_SCREEN.name
    ) {
        composable(route = Routes.SPLASH_SCREEN.name) {
            SplashScreen(navController = navController)
        }
        composable(route = Routes.ON_BOARDING.name) {
            OnBoarding(navController = navController)
        }
        composable(route = Routes.AUTHORIZATION.name) {
            BackNavigation(action = { navController.navigateUp() }) {
                Authorization(navController = navController)
            }
        }
        composable(route = Routes.REGISTRATION_PHONE.name) {
            BackNavigation(action = { navController.navigateUp() }) {
                Registration(navController = navController)
            }
        }

        composable(route = Routes.REGISTRATION_PIN_CODE.name) {
            RegistrationPinCode(navController = navController)
        }

        composable(route = Routes.REGISTRATION_CRE_PIN_CODE.name) {
            BackNavigation(action = { navController.navigateUp() }) {
                RegistrationCrePinCode(navController = navController)
            }
        }

        //Base screen
        composable(route = Routes.BASE_SCREEN.name) {
            BaseScreen(navController = navController)
        }

    }
}