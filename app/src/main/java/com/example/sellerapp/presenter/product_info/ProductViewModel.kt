package com.example.sellerapp.presenter.product_info

import com.example.sellerapp.core.framework.mvi.MviViewModel
import com.example.sellerapp.domain.usecase.GetProductByBarCodeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val getProductByBarCodeUseCase: GetProductByBarCodeUseCase) :
    MviViewModel<ProductViewState, ProductEvent, ProductEffect>() {

    override fun onTriggerEvent(eventType: ProductEvent) {
        when (eventType) {
            is ProductEvent.LoadProductInfo -> onLoadProductInfo(eventType.barcode)
            else -> {}
        }
    }

    private fun onLoadProductInfo(barcode: String) = safeLaunch {
        execute(getProductByBarCodeUseCase(GetProductByBarCodeUseCase.Params(barcode))) {
            setState(ProductViewState(product = it))
        }
    }
}