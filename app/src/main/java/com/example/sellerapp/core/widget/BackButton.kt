package com.example.sellerapp.core.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.sellerapp.R

@Composable
fun BackButton(action: () -> Unit) {
    Row(
        modifier = Modifier
            .size(50.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(colorResource(id = R.color.back_button_background))
            .clickable(onClick = action),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.arrow_right),
            contentDescription = "Arrow right",
            contentScale = ContentScale.Crop
        )
    }
//
//    Button(
//        onClick = action,
//        contentPadding = PaddingValues(
//            start = 0.dp,
//            top = 5.dp,
//            end = 0.dp,
//            bottom = 5.dp
//        ),
//        colors = ButtonDefaults.buttonColors(
//            containerColor = colorResource(id = R.color.back_button_background),
//            contentColor = Color.Black
//        ),
//        shape = RoundedCornerShape(20.dp)
//    ) {
//        Icon(Icons.Filled.KeyboardArrowLeft, contentDescription = "ArrowBack")
//    }
}