package com.example.sellerapp.domain.usecase

import com.example.sellerapp.core.framework.network.DataState
import com.example.sellerapp.core.framework.network.apiCall
import com.example.sellerapp.core.framework.usecase.DataStateUseCase
import com.example.sellerapp.domain.model.OnBoardingItem
import com.example.sellerapp.domain.repository.OnBoardingRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class GetOnBoardingItemsUseCase @Inject constructor(
    private val repository: OnBoardingRepository
) : DataStateUseCase<Unit, List<OnBoardingItem>>() {

    override suspend fun FlowCollector<DataState<List<OnBoardingItem>>>.execute(params: Unit) {
        val items = apiCall {
            repository.getOnBoarding();
        }

        emit(items)
    }
}