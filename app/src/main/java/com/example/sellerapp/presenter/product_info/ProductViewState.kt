package com.example.sellerapp.presenter.product_info

import com.example.sellerapp.core.framework.mvi.BaseEffect
import com.example.sellerapp.domain.model.Product

data class ProductViewState(
    val product: Product
)

sealed class ProductEvent {
    data class LoadProductInfo(val barcode: String): ProductEvent()
}

sealed class ProductEffect: BaseEffect() {

}