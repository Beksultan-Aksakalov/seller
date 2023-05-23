package com.example.sellerapp.presenter.onboarding

import com.example.sellerapp.core.framework.mvi.BaseEffect
import com.example.sellerapp.domain.model.OnBoardingItem

data class OnBoardingViewState (
    val items: List<OnBoardingItem>? = null
)

sealed class OnBoardingEvent {
    object LoadItems : OnBoardingEvent()
    object CheckAuthKey: OnBoardingEvent()
}

sealed class OnBoardingEffect: BaseEffect() {
    object OnNavigateToCellPhone: OnBoardingEffect()
    data class OnNavigateToPinCode(val authKey: String): OnBoardingEffect()
}