package com.example.sellerapp.core.navigation

import androidx.navigation.NavController
import com.example.sellerapp.presenter.destinations.HomeScreenDestination
import com.example.sellerapp.presenter.destinations.InputCellPhoneScreenDestination
import com.example.sellerapp.presenter.destinations.NewPinCodeScreenDestination
import com.example.sellerapp.presenter.destinations.OnBoardingScreenDestination
import com.example.sellerapp.presenter.destinations.PersonalInfoScreenDestination
import com.example.sellerapp.presenter.destinations.PinCodeScreenDestination
import com.example.sellerapp.presenter.destinations.ProductInfoScreenDestination
import com.example.sellerapp.presenter.destinations.ReceiptScreenDestination
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.navigation.popUpTo

class AppNavigationProvider(private val navController: NavController) : NavigationProvider {

    override fun navigateUp() {
        navController.navigateUp()
    }

    override fun openOnBoarding() {
        navController.navigate(
            OnBoardingScreenDestination
        ) {
            popUpTo(navController.graph.id)
        }
    }

    override fun openInputCellPhone() {
        navController.navigate(InputCellPhoneScreenDestination)
    }

    override fun openPinCode(changePin: Boolean, authKey: String?, cellPhone: String?) {
        navController.navigate(PinCodeScreenDestination(changePin, authKey, cellPhone))
    }

    override fun openNewPinCode(oldPin: String) {
        navController.navigate(
            NewPinCodeScreenDestination(oldPin)
        ) {
            popUpTo(InputCellPhoneScreenDestination)
        }
    }

    override fun openHome() {
        navController.navigate(
            HomeScreenDestination
        ) {
            popUpTo(navController.graph.id)
        }
    }

    override fun openPersonalInfo(firstname: String, lastname: String, cellphone: String) {
        navController.navigate(PersonalInfoScreenDestination(firstname, lastname, cellphone))
    }

    override fun openProductInfo(barcode: String) {
        navController.navigate(ProductInfoScreenDestination(barcode))
    }

    override fun openReceiptInfo(code: String) {
        navController.navigate(ReceiptScreenDestination(code))
    }

}