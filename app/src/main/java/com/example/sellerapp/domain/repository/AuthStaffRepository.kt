package com.example.sellerapp.domain.repository

import com.example.sellerapp.domain.model.AuthStaff

interface AuthStaffRepository {

    suspend fun authStaff(cellPhone: String, pin: String): AuthStaff

    suspend fun pinChange(newPin: String, oldPin: String)

    suspend fun pinCheck(pin: String)

    suspend fun onLogout()
}