package com.example.seller.network

import com.example.seller.data.api.OnBoardingApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClient {

    private val BASE_URL = "http://77.240.38.178/api/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val getApiService by lazy {
        retrofit.create(OnBoardingApi::class.java)
    }
}