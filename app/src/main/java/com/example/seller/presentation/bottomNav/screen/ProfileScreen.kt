package com.example.seller.presentation.bottomNav.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Text
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.seller.R
import com.example.seller.route.Routes

@Composable
fun ProfileScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(Color.White)
            .wrapContentSize(Alignment.Center)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column() {
                    Text(
                        "Профиль",
                        fontFamily = FontFamily.Default,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.W800,
                        fontSize = 32.sp,
                        lineHeight = 30.sp,
                    )

                    Text(
                        "Аксакалов Бексултан",
                        fontFamily = FontFamily.Default,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.W400,
                        fontSize = 16.sp,
                        lineHeight = 30.sp,
                        modifier = Modifier
                            .padding(0.dp, 7.dp, 0.dp, 0.dp),
                        color = colorResource(
                            id = R.color.cli_fio
                        )
                    )
                }

                Image(
                    painter = painterResource(R.drawable.profile_bottom_nav),
                    contentDescription = "Profile image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(50.dp)
                )
            }

            Divider(
                color = colorResource(id = R.color.background),
                thickness = 1.dp,
                modifier = Modifier.padding(0.dp, 48.dp, 0.dp, 20.dp)
            )

            Box(modifier = Modifier.clickable { navController.navigate(route = Routes.PROFILE_INFORMATION.name) }) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Личная информация",
                        fontFamily = FontFamily.Default,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.W600,
                        fontSize = 16.sp,
                        lineHeight = 30.sp,
                        color = colorResource(
                            id = R.color.black2
                        )
                    )

                    Image(
                        painter = painterResource(R.drawable.arrow_left),
                        contentDescription = "Arrow left",
                        contentScale = ContentScale.Crop
                    )
                }
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 35.dp, 0.dp, 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Пароль и безопасность",
                    fontFamily = FontFamily.Default,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.W600,
                    fontSize = 16.sp,
                    lineHeight = 30.sp,
                    color = colorResource(
                        id = R.color.black2
                    )
                )

                Image(
                    painter = painterResource(R.drawable.arrow_left),
                    contentDescription = "Arrow left",
                    contentScale = ContentScale.Crop
                )
            }
        }

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
                            "Выйти",
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