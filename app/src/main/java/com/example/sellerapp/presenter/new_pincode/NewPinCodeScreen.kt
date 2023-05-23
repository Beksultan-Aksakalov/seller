package com.example.sellerapp.presenter.new_pincode

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.sellerapp.core.framework.extension.collectInLaunchedEffect
import com.example.sellerapp.core.framework.mvi.BaseEffect
import com.example.sellerapp.core.navigation.NavigationProvider
import com.example.sellerapp.core.widget.LoadingView
import com.example.sellerapp.core.widget.SurfaceTopToolBarBack
import com.example.sellerapp.presenter.new_pincode.view.NewPinCodeContent
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun NewPinCodeScreen(
    oldPin: String,
    viewModel: NewPinCodeViewModel = hiltViewModel(),
    navigator: NavigationProvider
) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    SurfaceTopToolBarBack(
        onOnclickBackButton = { navigator.navigateUp() }
    ) {
        if (uiState.isLoading) {
            LoadingView()
        } else {
            NewPinCodeContent(
                onInputPinComplete = {
                    viewModel.onTriggerEvent(NewPinCodeEvent.PinChange(it, oldPin))
                }
            )
        }
    }

    viewModel.effect.collectInLaunchedEffect { effect ->
        when (effect) {
            is BaseEffect.OnError -> Toast.makeText(context, effect.message, Toast.LENGTH_SHORT)
                .show()

            is NewPinCodeEffect.OnNavigateHome -> navigator.openHome()
        }
    }
}