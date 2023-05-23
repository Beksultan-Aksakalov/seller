package com.example.sellerapp.domain.usecase

import com.example.sellerapp.core.framework.network.DataState
import com.example.sellerapp.core.framework.network.apiCall
import com.example.sellerapp.core.framework.usecase.DataStateUseCase
import com.example.sellerapp.domain.model.UserInfo
import com.example.sellerapp.domain.repository.UserRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class SaveUserInfoUseCase @Inject constructor(private val userRepository: UserRepository) :
    DataStateUseCase<SaveUserInfoUseCase.Params, UserInfo>() {

    data class Params(
        val firstname: String,
        val lastname: String,
        val cellphone: String
    )

    override suspend fun FlowCollector<DataState<UserInfo>>.execute(params: Params) {
        val result = apiCall {
            userRepository.saveUserInfo(
                UserInfo(
                    params.firstname,
                    params.lastname,
                    params.cellphone
                )
            )
        }
        emit(result)
    }
}