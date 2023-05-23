package com.example.sellerapp.core.navigation

interface NavigationProvider {

    fun navigateUp()

    fun openOnBoarding()

    fun openInputCellPhone()

    fun openPinCode(changePin: Boolean = false, authKey: String? = null, cellPhone: String? = null)

    fun openNewPinCode(oldPin: String)

    fun openHome()

    fun openPersonalInfo(
        firstname: String,
        lastname: String,
        cellphone: String
    )

    fun openProductInfo(barcode: String)

    fun openReceiptInfo(code: String)
}