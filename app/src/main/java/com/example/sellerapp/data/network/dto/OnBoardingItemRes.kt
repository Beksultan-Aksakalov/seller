package com.example.sellerapp.data.network.dto

import com.example.sellerapp.domain.model.OnBoardingItem

data class OnBoardingItemRes (
    val title: String,
    val description: String,
    val image: String
)

fun OnBoardingItemRes.toDomain() =
    OnBoardingItem(
        title,
        description,
        image
    )

fun List<OnBoardingItemRes>.toDomain() = map {
    it.toDomain()
}