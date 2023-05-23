package com.example.sellerapp.domain.usecase

import com.example.sellerapp.core.framework.network.DataState
import com.example.sellerapp.core.framework.network.apiCall
import com.example.sellerapp.core.framework.usecase.DataStateUseCase
import com.example.sellerapp.domain.model.AuthStaff
import com.example.sellerapp.domain.repository.AuthStaffRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class AuthStaffUseCase @Inject constructor(
    private val authStaffRepository: AuthStaffRepository
) :
    DataStateUseCase<AuthStaffUseCase.Params, AuthStaff>() {

    data class Params(
        val cellPhone: String,
        val pin: String
    )

    override suspend fun FlowCollector<DataState<AuthStaff>>.execute(params: Params) {
        val result = apiCall {
            authStaffRepository.authStaff(params.cellPhone, params.pin);
        }
        emit(result)
    }
}