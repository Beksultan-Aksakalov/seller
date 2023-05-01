package com.example.seller.presentation.hoc

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color

@Composable
fun LineProgressIndicator(initialState: Float, content: @Composable () -> Unit) {

    val progress by animateFloatAsState (
        targetValue = initialState,
        animationSpec =  ProgressIndicatorDefaults.ProgressAnimationSpec
    )

    Column {
        LinearProgressIndicator(progress = progress, color = Color.Black)
    }

}