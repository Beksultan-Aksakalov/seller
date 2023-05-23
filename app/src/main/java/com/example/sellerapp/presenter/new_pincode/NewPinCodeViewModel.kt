package com.example.sellerapp.presenter.new_pincode

import com.example.sellerapp.core.framework.mvi.BaseViewState
import com.example.sellerapp.core.framework.mvi.MviViewModel
import com.example.sellerapp.domain.usecase.PinChangeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewPinCodeViewModel @Inject constructor(
    private val pinChangeUseCase: PinChangeUseCase
) : MviViewModel<BaseViewState<NewPinCodeViewState>, NewPinCodeEvent, NewPinCodeEffect>() {

    override fun onTriggerEvent(eventType: NewPinCodeEvent) {
        when (eventType) {
            is NewPinCodeEvent.PinChange -> onNewPinCodeChanged(eventType.newPin, eventType.oldPin)
        }
    }

    private fun onNewPinCodeChanged(newPin: String, oldPin: String) = safeLaunch {
        execute(pinChangeUseCase(PinChangeUseCase.Params(newPin, oldPin))) {
            effectChannel.trySend(NewPinCodeEffect.OnNavigateHome)
        }
    }
}