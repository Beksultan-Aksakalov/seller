package com.example.sellerapp.domain.usecase

import com.example.sellerapp.core.framework.network.DataState
import com.example.sellerapp.core.framework.network.apiCall
import com.example.sellerapp.core.framework.usecase.DataStateUseCase
import com.example.sellerapp.domain.model.Product
import com.example.sellerapp.domain.repository.ProductRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class GetProductByBarCodeUseCase @Inject constructor(
    private val productRepository: ProductRepository
) : DataStateUseCase<GetProductByBarCodeUseCase.Params, Product>() {

    data class Params(
        val barcode: String,
        val storeId: Long = 1032,
        val uid: String? = null
    )

    override suspend fun FlowCollector<DataState<Product>>.execute(params: Params) {

        val result = apiCall {
            productRepository.getProductInfo(params.barcode, params.storeId, params.uid)
        }
        emit(result)
    }
}