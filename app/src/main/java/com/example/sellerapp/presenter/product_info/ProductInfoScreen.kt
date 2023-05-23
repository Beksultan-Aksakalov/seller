package com.example.sellerapp.presenter.product_info

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.sellerapp.core.framework.extension.collectInLaunchedEffect
import com.example.sellerapp.core.framework.mvi.BaseEffect
import com.example.sellerapp.core.navigation.NavigationProvider
import com.example.sellerapp.core.widget.LoadingView
import com.example.sellerapp.core.widget.SurfaceTopToolBarBack
import com.example.sellerapp.presenter.product_info.view.ProductInfoScreenContent
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun ProductInfoScreen(
    barcode: String,
    viewModel: ProductViewModel = hiltViewModel(),
    navigator: NavigationProvider
) {

    val uiState by viewModel.uiState.collectAsState()

    val context = LocalContext.current

    LaunchedEffect(key1 = viewModel) {
        viewModel.onTriggerEvent(ProductEvent.LoadProductInfo(barcode))
    }

    when (uiState.isLoading) {
        true -> LoadingView()
        false -> {
            uiState.state?.let {
                SurfaceTopToolBarBack(
                    onOnclickBackButton = { navigator.navigateUp() }
                ) {
                    ProductInfoScreenContent(it.product)
                }
            }
        }
    }

    viewModel.effect.collectInLaunchedEffect { effect ->
        when (effect) {
            is BaseEffect.OnError -> {
                Toast.makeText(context, effect.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}