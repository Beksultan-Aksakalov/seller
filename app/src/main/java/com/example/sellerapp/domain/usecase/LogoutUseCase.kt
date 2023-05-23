package com.example.sellerapp.domain.usecase

import com.example.sellerapp.core.framework.network.DataState
import com.example.sellerapp.core.framework.network.apiCall
import com.example.sellerapp.core.framework.usecase.DataStateUseCase
import com.example.sellerapp.domain.repository.AuthStaffRepository
import com.example.sellerapp.domain.repository.GlobalKeyValueRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val authStaffRepository: AuthStaffRepository,
    private val globalKeyValueRepository: GlobalKeyValueRepository
) :
    DataStateUseCase<Unit, Unit>() {

    override suspend fun FlowCollector<DataState<Unit>>.execute(params: Unit) {
        val result = apiCall {
            authStaffRepository.onLogout()
        }
        globalKeyValueRepository.clearAuthKey()
        emit(result)
    }
}