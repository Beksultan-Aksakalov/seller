package com.example.sellerapp.domain.usecase

import com.example.sellerapp.core.framework.network.DataState
import com.example.sellerapp.core.framework.network.apiCall
import com.example.sellerapp.core.framework.usecase.DataStateUseCase
import com.example.sellerapp.domain.repository.AuthStaffRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class PinCheckUseCase @Inject constructor(private val authStaffRepository: AuthStaffRepository) :
    DataStateUseCase<String, Unit>() {

    override suspend fun FlowCollector<DataState<Unit>>.execute(params: String) {
        val result = apiCall {
            authStaffRepository.pinCheck(params);
        }
        emit(result)
    }

}