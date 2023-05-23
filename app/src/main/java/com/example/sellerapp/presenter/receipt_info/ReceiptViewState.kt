package com.example.sellerapp.presenter.receipt_info

import com.example.sellerapp.core.framework.mvi.BaseEffect
import com.example.sellerapp.domain.model.Receipt

data class ReceiptViewState(
    val receipt: Receipt
)

sealed class ReceiptEvent {
    data class LoadReceiptInfo(val code: String): ReceiptEvent()
}

sealed class ReceiptEffect: BaseEffect() {

}