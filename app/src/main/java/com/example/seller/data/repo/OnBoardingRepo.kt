package com.example.seller.data.repo

import com.example.seller.data.api.model.dto.OnBoardingDTO
import com.example.seller.data.api.OnBoardingApi
import retrofit2.Call
import javax.inject.Inject

//class OnBoardingRepo @Inject constructor(private val onBoardingApi: OnBoardingApi) {
//
//    fun getAllOnBoardingList(): List<OnBoardingDTO> {
//        return onBoardingApi.getInfo()
//    }
//
//}

class OnBoardingRepo(private val onBoardingApi: OnBoardingApi) {
    suspend fun getAllOnBoardingList(): List<OnBoardingDTO> {
        return onBoardingApi.getInfo()
    }
}