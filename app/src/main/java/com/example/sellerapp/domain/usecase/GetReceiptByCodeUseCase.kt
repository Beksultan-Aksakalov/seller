package com.example.sellerapp.domain.usecase

import com.example.sellerapp.core.framework.network.DataState
import com.example.sellerapp.core.framework.network.apiCall
import com.example.sellerapp.core.framework.usecase.DataStateUseCase
import com.example.sellerapp.domain.model.Receipt
import com.example.sellerapp.domain.repository.ReceiptRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class GetReceiptByCodeUseCase @Inject constructor(private val receiptRepository: ReceiptRepository) :
    DataStateUseCase<GetReceiptByCodeUseCase.Params, Receipt>() {

    data class Params(
        val code: String,
    )

    override suspend fun FlowCollector<DataState<Receipt>>.execute(params: Params) {
        val result = apiCall {
            receiptRepository.getReceiptInfo(params.code)
        }
        emit(result)
    }
}