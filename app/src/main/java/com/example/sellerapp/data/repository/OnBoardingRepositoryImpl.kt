package com.example.sellerapp.data.repository

import com.example.sellerapp.data.network.ApiService
import com.example.sellerapp.data.network.dto.toDomain
import com.example.sellerapp.domain.model.OnBoardingItem
import com.example.sellerapp.domain.repository.OnBoardingRepository
import javax.inject.Inject

class OnBoardingRepositoryImpl @Inject constructor(
    private val api: ApiService): OnBoardingRepository {

    override suspend fun getOnBoarding(): List<OnBoardingItem> {
        return api.getOnBoarding().toDomain();
    }
}