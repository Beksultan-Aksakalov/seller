package com.example.sellerapp.data.network.dto

import com.example.sellerapp.domain.model.Receipt
import com.example.sellerapp.domain.model.State as DomainState
import com.example.sellerapp.domain.model.Store as DomainStore
import com.example.sellerapp.domain.model.PaymentType as DomainPaymentType
import com.example.sellerapp.domain.model.Items as DomainItems
import com.example.sellerapp.domain.model.Item as DomainItem

data class ReceiptRes(
    val id: Int,
    val price: Long,
    val regDate: String,
    val state: State,
    val store: Store,
    val paymentType: PaymentType,
    val items: List<Items>,
    val qrCode: String
)

fun ReceiptRes.toDomain() =
    Receipt(
        id,
        price,
        regDate,
        state.toDomain(),
        store.toDomain(),
        paymentType.toDomain(),
        items.toDomain(),
        qrCode
    )

data class State(
    val stateId: Int,
    val descr: String,
    val color: String
)

fun State.toDomain() = DomainState(stateId, descr, color)

data class Store(
    val id: Int,
    val title: String,
    val logo: String,
    val color: String
)

fun Store.toDomain() = DomainStore(id, title, logo, color)

data class PaymentType(
    val stateId: Int,
    val descr: String
)

fun PaymentType.toDomain() = DomainPaymentType(stateId, descr)

data class Items(
    val quantity: Int,
    val price: Int,
    val totalPrice: Int,
    val item: Item
)

fun Items.toDomain() = DomainItems(quantity, price, totalPrice, item.toDomain())

fun List<Items>.toDomain() = map { items: Items -> items.toDomain() }

data class Item(
    val id: Int,
    val title: String,
    val measureUnit: MeasureUnit
)

fun Item.toDomain() = DomainItem(id, title, measureUnit.toDomain())

