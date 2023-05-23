package com.example.sellerapp.domain.usecase

import com.example.sellerapp.core.framework.usecase.LocalUseCase
import com.example.sellerapp.domain.repository.GlobalKeyValueRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class ClearAuthKeyUseCase  @Inject constructor(private val repository: GlobalKeyValueRepository) :
    LocalUseCase<Unit, Unit>() {

    override suspend fun FlowCollector<Unit>.execute(params: Unit) {
        repository.clearAuthKey()
        emit(Unit)
    }
}