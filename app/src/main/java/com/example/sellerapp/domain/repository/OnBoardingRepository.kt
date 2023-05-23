package com.example.sellerapp.domain.repository

import com.example.sellerapp.domain.model.OnBoardingItem

interface OnBoardingRepository {

    suspend fun getOnBoarding(): List<OnBoardingItem>
}