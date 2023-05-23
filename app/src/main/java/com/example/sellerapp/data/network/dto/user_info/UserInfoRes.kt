package com.example.sellerapp.data.network.dto.user_info

import com.example.sellerapp.domain.model.UserInfo

data class UserInfoRes(
    val firstname: String,
    val lastname: String,
    val cellphone: String
)

fun UserInfoRes.toDomain() =
    UserInfo(
        firstname,
        lastname,
        cellphone
    )