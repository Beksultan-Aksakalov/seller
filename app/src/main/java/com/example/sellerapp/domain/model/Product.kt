package com.example.sellerapp.domain.model

class Product (
    val id: Int,
    val title: String,
    val measureUnit: MeasureUnit,
    val price: Long,
    val description: String,
    val barcode: String,
    val uid: String
)

data class MeasureUnit(
    val title: String,
    val divValue: Int,
    val step: Int,
    val id: Long
)