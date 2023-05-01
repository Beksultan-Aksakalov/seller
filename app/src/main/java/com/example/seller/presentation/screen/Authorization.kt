package com.example.seller.presentation.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.seller.presentation.hoc.OtpBottomSheet

@Composable
fun Authorization(navController: NavController) {
   OtpBottomSheet(true)
}