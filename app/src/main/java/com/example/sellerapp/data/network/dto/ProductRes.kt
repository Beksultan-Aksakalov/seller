package com.example.sellerapp.data.network.dto

import com.example.sellerapp.domain.model.Product
import com.example.sellerapp.domain.model.MeasureUnit as DomainMeasureUnit

data class ProductRes(
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

fun MeasureUnit.toDomain() =
    DomainMeasureUnit(title, divValue, step, id)

fun ProductRes.toDomain() =
    Product(
        id,
        title,
        measureUnit = measureUnit.toDomain(),
        price,
        description,
        barcode,
        uid)
