package com.example.seller.presentation.bottomNav.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.seller.R

@Composable
fun QRCodeScreen() {
    var isClikedBarcode by rememberSaveable { mutableStateOf(false) }
    var isClikedLoyal by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White),
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(0.dp, 0.dp, 0.dp, 75.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            ExtendedFloatingActionButton(
                modifier = Modifier.size(width = 160.dp, height = 52.dp),
                icon = {
                    Icon(
                        painterResource(R.drawable.barcode_btn),
                        contentDescription = "Чек"
                    )
                },
                text = {
                    Text(
                        "Чек",
                        fontFamily = FontFamily.Default,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.W600,
                        fontSize = 14.sp,
                        lineHeight = 30.sp
                    )
                },
                backgroundColor = if (isClikedBarcode) Color.Black else Color.LightGray,
                contentColor = if (isClikedBarcode) Color.White else Color.Black,
                onClick = {
                    isClikedBarcode = true
                    isClikedLoyal = false
                }
            )

            ExtendedFloatingActionButton(
                modifier = Modifier.size(width = 160.dp, height = 52.dp),
                icon = {
                    Icon(
                        painterResource(R.drawable.barcode_btn),
                        contentDescription = "Лояльность"
                    )
                },
                text = {
                    Text(
                        "Лояльность",
                        fontFamily = FontFamily.Default,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.W600,
                        fontSize = 13.sp,
                        lineHeight = 10.sp,
                    )
                },
                backgroundColor = if (isClikedLoyal) Color.Black else Color.LightGray,
                contentColor = if (isClikedLoyal) Color.White else Color.Black,
                onClick = {
                    isClikedLoyal = true
                    isClikedBarcode = false
                }
            )
        }
    }
}