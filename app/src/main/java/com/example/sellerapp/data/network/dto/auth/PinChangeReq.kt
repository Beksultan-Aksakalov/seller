package com.example.sellerapp.data.network.dto.auth

data class PinChangeReq(
    val newPin: String,
    val oldPin: String
)

