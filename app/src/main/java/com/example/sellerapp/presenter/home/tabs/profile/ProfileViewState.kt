package com.example.sellerapp.presenter.home.tabs.profile

import com.example.sellerapp.core.framework.mvi.BaseEffect
import com.example.sellerapp.domain.model.UserInfo

data class ProfileViewState(
    val userInfo: UserInfo
)

sealed class ProfileEvent {
    object LoadUserInfo : ProfileEvent()
    object Logout: ProfileEvent()
}

sealed class ProfileEffect : BaseEffect() {
    object OnLogout: ProfileEffect()
}
