package com.example.sellerapp.domain.model

data class UserInfo(
    val firstname: String,
    val lastname: String,
    val cellphone: String
)

fun UserInfo.longname() = "$lastname $firstname"