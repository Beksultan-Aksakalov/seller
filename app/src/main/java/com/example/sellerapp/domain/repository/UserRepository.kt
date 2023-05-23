package com.example.sellerapp.domain.repository

import com.example.sellerapp.domain.model.UserInfo

interface UserRepository {

    suspend fun getUserInfo(): UserInfo

    suspend fun saveUserInfo(userInfo: UserInfo): UserInfo
}