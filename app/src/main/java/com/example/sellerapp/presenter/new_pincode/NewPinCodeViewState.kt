package com.example.sellerapp.presenter.new_pincode

import com.example.sellerapp.core.framework.mvi.BaseEffect

data class NewPinCodeViewState(
    val changed: Boolean
)

sealed class NewPinCodeEvent {
    data class PinChange(val newPin: String, val oldPin: String) : NewPinCodeEvent()
}

sealed class NewPinCodeEffect: BaseEffect() {
    object OnNavigateHome: NewPinCodeEffect()
}