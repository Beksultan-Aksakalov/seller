package com.example.sellerapp.data.network.dto.user_info

import com.example.sellerapp.domain.model.UserInfo

data class UserInfoReq(
    private val firstname: String?,
    private val lastname: String?
)

fun UserInfo.toDto() =
    UserInfoReq(firstname, lastname)