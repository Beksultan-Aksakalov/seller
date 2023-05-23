package com.example.sellerapp.presenter.input_cell_phone

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.sellerapp.R
import com.example.sellerapp.core.navigation.NavigationProvider
import com.example.sellerapp.core.widget.SurfaceTopToolBarBack
import com.example.sellerapp.presenter.input_cell_phone.view.InputCellPhoneContent
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun InputCellPhoneScreen(
    navigator: NavigationProvider
) {
    val context = LocalContext.current

    SurfaceTopToolBarBack(
        onOnclickBackButton = { navigator.navigateUp() }
    ) {
        InputCellPhoneContent(
            onClickNext = {
                if (it.length == 11) {
                    navigator.openPinCode(cellPhone = it)
                } else {
                    Toast.makeText(
                        context,
                        context.getString(R.string.input_correct_format_phone),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        )
    }
}
