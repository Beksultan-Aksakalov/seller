package com.example.sellerapp.domain.usecase

import com.example.sellerapp.core.framework.network.DataState
import com.example.sellerapp.core.framework.network.apiCall
import com.example.sellerapp.core.framework.usecase.DataStateUseCase
import com.example.sellerapp.domain.repository.AuthStaffRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class PinChangeUseCase @Inject constructor(private val authStaffRepository: AuthStaffRepository):
DataStateUseCase<PinChangeUseCase.Params, Unit>(){

    data class Params(
        val newPin: String,
        val oldPin: String
    )

    override suspend fun FlowCollector<DataState<Unit>>.execute(params: Params) {
        val result = apiCall {
            authStaffRepository.pinChange(params.newPin, params.oldPin);
        }
        emit(result)
    }
}