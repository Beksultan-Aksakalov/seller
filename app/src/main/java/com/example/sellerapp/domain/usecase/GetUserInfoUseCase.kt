package com.example.sellerapp.domain.usecase

import com.example.sellerapp.core.framework.network.DataState
import com.example.sellerapp.core.framework.network.apiCall
import com.example.sellerapp.core.framework.usecase.DataStateUseCase
import com.example.sellerapp.domain.model.UserInfo
import com.example.sellerapp.domain.repository.UserRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class GetUserInfoUseCase @Inject constructor(private val userRepository: UserRepository): DataStateUseCase<Unit, UserInfo>() {

    override suspend fun FlowCollector<DataState<UserInfo>>.execute(params: Unit) {
        val result = apiCall {
            userRepository.getUserInfo()
        }
        emit(result)
    }
}