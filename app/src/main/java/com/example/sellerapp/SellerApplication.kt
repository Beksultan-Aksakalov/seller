package com.example.sellerapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SellerApplication(val key: String? = null): Application() {

}