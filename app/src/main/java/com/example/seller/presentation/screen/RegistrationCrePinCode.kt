package com.example.seller.presentation.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.seller.R
import com.example.seller.presentation.hoc.OtpTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationCrePinCode(navController: NavController) {

    val context = LocalContext.current

    var otpValue by rememberSaveable { mutableStateOf("") }

    Toast.makeText(context, otpValue, Toast.LENGTH_SHORT).show()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)
    ) {

        Column(modifier = Modifier.padding(20.dp)) {
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

            OtpTextField(
                otpText = otpValue,
                onOtpTextChange = { value, otpInputFilled ->
                    otpValue = value
                }
            )
        }
    }
}
