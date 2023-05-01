package com.example.seller.presentation.bottomNav

import com.example.seller.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

    object Barcode : BottomNavItem("", R.drawable.home_bottom_nav,"barcode")
    object QRCode: BottomNavItem("",R.drawable.barcode_botton_nav,"qr code")
    object Profile: BottomNavItem("",R.drawable.profile_bottom_nav,"profile")
}