package com.example.sellerapp.data.network.dto.auth

import com.example.sellerapp.domain.model.AuthStaff

data class AuthStaffRes(
    val key: String,
    val changePin: Boolean
)

fun AuthStaffRes.toDomain() =
    AuthStaff(key = key, changePin = changePin)