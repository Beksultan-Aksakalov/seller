package com.example.sellerapp.presenter.personal_info

import com.example.sellerapp.core.framework.mvi.BaseEffect
import com.example.sellerapp.domain.model.UserInfo

data class PersonalInfoViewState(
    val userInfo: UserInfo
)

sealed class PersonalInfoEvent {
    data class SavePersonalInfo(val fullName: String, val cellPhone: String) : PersonalInfoEvent()
}

sealed class PersonalInfoEffect : BaseEffect() {
    object OnAfterSave : PersonalInfoEffect()
}