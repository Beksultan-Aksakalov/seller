package com.example.sellerapp.data.repository

import com.example.sellerapp.data.network.ApiService
import com.example.sellerapp.data.network.dto.auth.AuthStaffReq
import com.example.sellerapp.data.network.dto.auth.PinChangeReq
import com.example.sellerapp.data.network.dto.auth.PinCheckReq
import com.example.sellerapp.data.network.dto.auth.toDomain
import com.example.sellerapp.domain.model.AuthStaff
import com.example.sellerapp.domain.repository.AuthStaffRepository
import javax.inject.Inject

class AuthStaffRepositoryImpl @Inject constructor(val apiService: ApiService) :
    AuthStaffRepository {

    override suspend fun authStaff(cellPhone: String, pin: String): AuthStaff {
        return apiService.authStaff(AuthStaffReq(cellPhone, pin)).toDomain()
    }

    override suspend fun pinChange(newPin: String, oldPin: String) {
        return apiService.authPinChange(PinChangeReq(newPin, oldPin))
    }

    override suspend fun pinCheck(pin: String) {
        return apiService.authPinCheck(PinCheckReq(pin))
    }

    override suspend fun onLogout() {
        return apiService.authLogout()
    }
}