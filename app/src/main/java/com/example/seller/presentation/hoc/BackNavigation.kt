package com.example.seller.presentation.hoc

import android.graphics.drawable.shapes.Shape
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.seller.R

@Composable
fun BackNavigation(action: () -> Unit, content: @Composable () -> Unit) {
    BackHandler {
        action()
    }
    Column(modifier = Modifier.background(Color.White)) {
        Row(
            modifier = Modifier
                .align(alignment = Alignment.Start)
                .wrapContentWidth()
                .padding(2.dp)
        ) {
            BackButton(action = action)
        }
        content()
    }
}

@Composable
fun BackButton(action: () -> Unit) {
    Button(
        onClick = action,
        contentPadding = PaddingValues(
            start = 0.dp,
            top = 5.dp,
            end = 0.dp,
            bottom = 5.dp
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.back_button_background),
            contentColor = Color.Black
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Icon(Icons.Filled.KeyboardArrowLeft, contentDescription = "ArrowBack")
    }
}