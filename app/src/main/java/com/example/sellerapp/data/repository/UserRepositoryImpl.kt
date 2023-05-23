package com.example.sellerapp.data.repository

import com.example.sellerapp.data.network.ApiService
import com.example.sellerapp.data.network.dto.user_info.toDomain
import com.example.sellerapp.data.network.dto.user_info.toDto
import com.example.sellerapp.domain.model.UserInfo
import com.example.sellerapp.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val apiService: ApiService) : UserRepository {

    override suspend fun getUserInfo(): UserInfo {
        return apiService.getUserInfo().toDomain()
    }

    override suspend fun saveUserInfo(userInfo: UserInfo): UserInfo {
        return apiService.updateUserInfo(userInfo.toDto()).toDomain()
    }
}