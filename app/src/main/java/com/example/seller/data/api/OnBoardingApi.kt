package com.example.seller.data.api

import com.example.seller.data.api.model.dto.OnBoardingDTO
import retrofit2.http.GET

interface OnBoardingApi {

    @GET("info/onboarding")
    fun getInfo(): List<OnBoardingDTO>
}