package com.example.sellerapp.presenter.receipt_info

import com.example.sellerapp.core.framework.mvi.MviViewModel
import com.example.sellerapp.domain.usecase.GetReceiptByCodeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ReceiptViewModel @Inject constructor(private val getReceiptByCodeUseCase: GetReceiptByCodeUseCase) :
    MviViewModel<ReceiptViewState, ReceiptEvent, ReceiptEffect>() {

    override fun onTriggerEvent(eventType: ReceiptEvent) {
        when (eventType) {
            is ReceiptEvent.LoadReceiptInfo -> onLoadReceiptInfo(eventType.code)
        }
    }

    private fun onLoadReceiptInfo(code: String) = safeLaunch {
        execute(getReceiptByCodeUseCase(GetReceiptByCodeUseCase.Params(code))) {
            setState(ReceiptViewState(receipt = it))
        }
    }
}