package com.example.sellerapp.domain.usecase

import com.example.sellerapp.core.framework.usecase.LocalUseCase
import com.example.sellerapp.domain.repository.GlobalKeyValueRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class AuthKeySaveUseCase @Inject constructor(private val repository: GlobalKeyValueRepository) :
    LocalUseCase<AuthKeySaveUseCase.Params, Unit>() {

    data class Params(
        val key: String
    )

    override suspend fun FlowCollector<Unit>.execute(params: Params) {
        repository.putAuthKey(params.key)
        emit(Unit)
    }
}