package com.example.sellerapp.domain.model

import java.util.Date

data class Receipt(
    val id: Int,
    val price: Long,
    val regDate: String,
    val state: State,
    val store: Store,
    val paymentType: PaymentType,
    val items: List<Items>,
    val qrCode: String
)

data class State(
    val stateId: Int,
    val descr: String,
    val color: String
)

data class Store(
    val id: Int,
    val title: String,
    val logo: String,
    val color: String
)

data class PaymentType(
    val stateId: Int,
    val descr: String
)

data class Items(
    val quantity: Int,
    val price: Int,
    val totalPrice: Int,
    val item: Item
)

data class Item(
    val id: Int,
    val title: String,
    val measureUnit: MeasureUnit
)