package com.example.seller.presentation.bottomNav.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import com.example.seller.R

@Composable
fun ProfileInformation(navController: NavController) {
    val fullName = remember { mutableStateOf("") }
    val phone = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }

    val maxCharFullName = 30
    val maxCharPhone = 12
    val maxEmail = 30

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(Color.White)
            .wrapContentSize(Alignment.Center)
    ) {

        Box(
            modifier = Modifier
                .background(
                    color = colorResource(id = R.color.background),
                    shape = RoundedCornerShape(80.dp),
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,

                ) {
                TextField(
                    value = fullName.value,
                    onValueChange = { newText ->
                        if (newText.length <= maxCharFullName) fullName.value = newText
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Gray,
                        disabledTextColor = Color.Gray,
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    singleLine = true,
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                        autoCorrect = true,
                        keyboardType = KeyboardType.Text,
                    ),
                )
                Image(
                    painter = painterResource(R.drawable.edit),
                    contentDescription = "Edit",
                    contentScale = ContentScale.Crop
                )
            }
        }

        Text(
            text = "${fullName.value.length} / $maxCharFullName",
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.caption,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 2.dp, end = 70.dp, bottom = 20.dp)
        )

        Box(
            modifier = Modifier
                .background(
                    color = colorResource(id = R.color.background),
                    shape = RoundedCornerShape(80.dp),
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,

                ) {
                TextField(
                    value = phone.value,
                    onValueChange = { newText ->
                        if (newText.length <= maxCharPhone) phone.value = newText
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Gray,
                        disabledTextColor = Color.Gray,
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    singleLine = true,
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                        autoCorrect = true,
                        keyboardType = KeyboardType.Phone,
                    ),
                )
                Image(
                    painter = painterResource(R.drawable.edit),
                    contentDescription = "Edit",
                    contentScale = ContentScale.Crop
                )
            }
        }

        Text(
            text = "${phone.value.length} / $maxCharPhone",
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.caption,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 2.dp, end = 70.dp, bottom = 20.dp)
        )

        Box(
            modifier = Modifier
                .background(
                    color = colorResource(id = R.color.background),
                    shape = RoundedCornerShape(80.dp),
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,

                ) {
                TextField(
                    value = email.value,
                    onValueChange = { newText ->
                        if (newText.length <= maxEmail) email.value = newText
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Gray,
                        disabledTextColor = Color.Gray,
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    singleLine = true,
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                        autoCorrect = true,
                        keyboardType = KeyboardType.Email,
                    ),
                )
                Image(
                    painter = painterResource(R.drawable.edit),
                    contentDescription = "Edit",
                    contentScale = ContentScale.Crop
                )
            }
        }

        Text(
            text = "${email.value.length} / $maxEmail",
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.caption,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 2.dp, end = 70.dp)
        )


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(0.dp, 0.dp, 0.dp, 55.dp),
                horizontalArrangement = Arrangement.Center
            ) {

                ExtendedFloatingActionButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = {
                        Text(
                            "Сохранить",
                            fontFamily = FontFamily.Default,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.W600,
                            fontSize = 14.sp,
                            lineHeight = 30.sp,
                        )
                    },
                    backgroundColor = Color.Black,
                    contentColor = Color.White,
                    onClick = {

                    }
                )

            }
        }
    }
}