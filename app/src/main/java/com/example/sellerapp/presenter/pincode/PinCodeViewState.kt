package com.example.sellerapp.presenter.pincode

import com.example.sellerapp.core.framework.mvi.BaseEffect
import com.example.sellerapp.domain.model.UserInfo

data class PinCodeViewState(
    val userInfo: UserInfo
)

sealed class PinCodeEvent {
    data class Authorization(val cellPhone: String, val pin: String) : PinCodeEvent()
    object LoadUserInfo: PinCodeEvent()
    data class PinCheck(val pin: String): PinCodeEvent()
    object Logout: PinCodeEvent()
    data class PinChange(val oldPin: String, val newPin: String): PinCodeEvent()
}

sealed class PinCodeEffect: BaseEffect() {
    object OnNavigateHome: PinCodeEffect()
    data class OnNavigateNewPinCode(val oldPin: String): PinCodeEffect()
    object OnLogout: PinCodeEffect()
    object OnReturnToProfile: PinCodeEffect()
}