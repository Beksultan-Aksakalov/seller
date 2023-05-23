package com.example.sellerapp.presenter.home.tabs.profile

import com.example.sellerapp.core.framework.mvi.MviViewModel
import com.example.sellerapp.domain.usecase.GetUserInfoUseCase
import com.example.sellerapp.domain.usecase.LogoutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getUserInfoUseCase: GetUserInfoUseCase,
    private val logoutUseCase: LogoutUseCase,
) : MviViewModel<ProfileViewState, ProfileEvent, ProfileEffect>() {

    override fun onTriggerEvent(eventType: ProfileEvent) {
        when (eventType) {
            is ProfileEvent.LoadUserInfo -> onLoadUserInfo()
            is ProfileEvent.Logout -> onLogout()
        }
    }

    private fun onLoadUserInfo() = safeLaunch {
        execute(getUserInfoUseCase(Unit)) {
            setState(ProfileViewState(userInfo = it))
        }
    }

    private fun onLogout() = safeLaunch {
        execute(logoutUseCase(Unit)){
            effectChannel.trySend(ProfileEffect.OnLogout)
        }
    }
}