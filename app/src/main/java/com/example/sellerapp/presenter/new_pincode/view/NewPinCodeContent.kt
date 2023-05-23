package com.example.sellerapp.presenter.new_pincode.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sellerapp.R

@Composable
fun NewPinCodeContent(
    onInputPinComplete: (newPin: String) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)
            .padding(20.dp)
    ) {

        LinearProgressIndicator(
            progress = 1f,
            modifier = Modifier
                .padding(top = 30.dp, bottom = 40.dp)
                .fillMaxWidth()
                .height(2.dp),
            color = colorResource(id = R.color.black2)
        )

        Text(
            text = "Придумайте пин код".uppercase(),
            fontFamily = FontFamily.Default,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.W800,
            fontSize = 24.sp,
            lineHeight = 30.sp,
            color = colorResource(id = R.color.black2),
        )

        Text(
            text = "Чтобы подтвердить учетную запись, введите 4-значный код, отправленный на номер +7 705 123 4567",
            fontFamily = FontFamily.Default,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.W300,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            color = colorResource(id = R.color.black2),
            modifier = Modifier.padding(0.dp, 11.dp, 0.dp, 0.dp)
        )

        Text(
            text = "Код",
            fontFamily = FontFamily.Default,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.W700,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            color = colorResource(id = R.color.black2),
            modifier = Modifier.padding(0.dp, 14.dp, 0.dp, 0.dp)
        )

        NewPinCodeView(
            onInputPinCompleted = { onInputPinComplete(it) }
        )
    }
}