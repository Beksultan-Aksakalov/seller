package com.example.sellerapp.presenter.pincode

import com.example.sellerapp.core.framework.mvi.MviViewModel
import com.example.sellerapp.domain.usecase.AuthKeySaveUseCase
import com.example.sellerapp.domain.usecase.AuthStaffUseCase
import com.example.sellerapp.domain.usecase.GetUserInfoUseCase
import com.example.sellerapp.domain.usecase.LogoutUseCase
import com.example.sellerapp.domain.usecase.PinChangeUseCase
import com.example.sellerapp.domain.usecase.PinCheckUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PinCodeViewModel @Inject constructor(
    private val authStaffUseCase: AuthStaffUseCase,
    private val authKeySaveUseCase: AuthKeySaveUseCase,
    private val getUserInfoUseCase: GetUserInfoUseCase,
    private val pinCheckUseCase: PinCheckUseCase,
    private val logoutUseCase: LogoutUseCase,
    private val pinChangeUseCase: PinChangeUseCase
) : MviViewModel<PinCodeViewState, PinCodeEvent, PinCodeEffect>() {

    override fun onTriggerEvent(eventType: PinCodeEvent) {
        when (eventType) {
            is PinCodeEvent.Authorization -> onAuthorization(
                eventType.cellPhone,
                eventType.pin
            )

            is PinCodeEvent.LoadUserInfo -> onLoadUserInfo()
            is PinCodeEvent.PinCheck -> onPickCheck(eventType.pin)
            is PinCodeEvent.Logout -> onLogout()
            is PinCodeEvent.PinChange -> onChangedPin(eventType.oldPin, eventType.newPin)
        }
    }

    private fun onAuthorization(cellPhone: String, pin: String) = safeLaunch {
        execute(authStaffUseCase(AuthStaffUseCase.Params(cellPhone, pin))) {
            safeLaunch {
                call(authKeySaveUseCase(AuthKeySaveUseCase.Params(it.key)))
            }
            if (it.changePin) {
                effectChannel.trySend(PinCodeEffect.OnNavigateNewPinCode(pin))
            } else {
                effectChannel.trySend(PinCodeEffect.OnNavigateHome)
            }
        }
    }

    private fun onLoadUserInfo() = safeLaunch {
        execute(getUserInfoUseCase(Unit)) {
            setState(PinCodeViewState(userInfo = it))
        }
    }

    private fun onPickCheck(pin: String) = safeLaunch {
        execute(pinCheckUseCase(pin)) {
            effectChannel.trySend(PinCodeEffect.OnNavigateHome)
        }
    }

    private fun onLogout() = safeLaunch {
        execute(logoutUseCase(Unit)) {
            effectChannel.trySend(PinCodeEffect.OnLogout)
        }
    }

    private fun onChangedPin(oldPin: String, newPin: String) = safeLaunch {
        execute(pinChangeUseCase(PinChangeUseCase.Params(newPin, oldPin))){
            effectChannel.trySend(PinCodeEffect.OnReturnToProfile)
        }
    }
}