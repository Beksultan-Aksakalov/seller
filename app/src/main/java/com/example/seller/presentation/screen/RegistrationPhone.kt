package com.example.seller.presentation.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import com.example.seller.presentation.hoc.PhoneField
import com.example.seller.route.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Registration(navController: NavController) {

    var phoneNumber by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(20.dp),
    ) {

        Text(
            text = "ДОБАВИТЬ НОМЕР",
            fontFamily = FontFamily.Default,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.W800,
            fontSize = 24.sp,
            lineHeight = 30.sp,
            color = colorResource(id = R.color.black2),
        )

        Text(
            text = "Мы должны подтвердить его, отправив\n" + "сообщение",
            fontFamily = FontFamily.Default,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.W300,
            fontSize = 15.sp,
            lineHeight = 20.sp,
            color = colorResource(id = R.color.black2),
            modifier = Modifier
                .padding(0.dp, 11.dp, 0.dp, 0.dp),
        )

        Text(
            text = "Номер телфона",
            fontFamily = FontFamily.Default,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.W700,
            fontSize = 16.sp,
            lineHeight = 30.sp,
            color = colorResource(id = R.color.black2),
            modifier = Modifier
                .padding(0.dp, 11.dp, 0.dp, 0.dp),
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 10.dp, 0.dp, 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Box(
                modifier = Modifier
                    .size(width = 160.dp, height = 52.dp)
            ) {
                Demo_ExposedDropdownMenuBox()
            }

            Box(modifier = Modifier.size(width = 190.dp, height = 52.dp)) {
                PhoneField(
                    phoneNumber,
                    mask = "+7 (000) 000 0000",
                    maskNumber = '0',
                    onPhoneChanged = { phoneNumber = it },
                    modifier = Modifier
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 20.dp, 0.dp, 0.dp),
        ) {
            Button(
                onClick = { navController.navigate(route = Routes.REGISTRATION_PIN_CODE.name) },
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .width(335.dp)
                    .height(52.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White, containerColor = Color.Black
                ),
                shape = RoundedCornerShape(80.dp)

            ) {
                Text(text = "Далее")
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 10.dp, 0.dp, 0.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { navController.navigate(route = Routes.REGISTRATION_CRE_PIN_CODE.name) },
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .width(100.dp)
                    .height(52.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White, containerColor = Color.Black
                ),
                shape = RoundedCornerShape(80.dp)

            ) {
                Text(text = "Далее Cre pincode")
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 10.dp, 0.dp, 0.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { navController.navigate(route = Routes.BASE_SCREEN.name) },
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .width(100.dp)
                    .height(52.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White, containerColor = Color.Black
                ),
                shape = RoundedCornerShape(80.dp)

            ) {
                Text(text = "Домой")
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 10.dp, 0.dp, 0.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { navController.navigate(route = Routes.AUTHORIZATION.name) },
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .width(100.dp)
                    .height(52.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White, containerColor = Color.Black
                ),
                shape = RoundedCornerShape(80.dp)

            ) {
                Text(text = "Авторизация")
            }
        }

        Text(
            text = "Продолжая, вы подтверждаете, что являетесь владельцем или основным пользователем этого номера мобильного телефона. Вы соглашаетесь получать автоматические текстовые сообщения для подтверждения вашего номера телефона.",
            fontFamily = FontFamily.Default,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.W300,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            maxLines = 5,
            color = colorResource(id = R.color.tv_gray),
            modifier = Modifier
                .padding(0.dp, 35.dp, 0.dp, 0.dp),
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Demo_ExposedDropdownMenuBox() {
    val context = LocalContext.current

    val countries = arrayOf("Казахстан", "Америка", "Китай", "Узбекистан", "Россия")

    var expanded by rememberSaveable { mutableStateOf(false) }
    var selectedText by rememberSaveable { mutableStateOf(countries[0]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {
        TextField(
            value = selectedText,
            onValueChange = {},
            readOnly = true,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            modifier = Modifier
                .menuAnchor(),
            shape = RoundedCornerShape(80.dp),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
            ),
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            countries.forEach { item ->
                DropdownMenuItem(
                    text = { Text(text = item) },
                    onClick = {
                        selectedText = item
                        expanded = false
                        Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }
}