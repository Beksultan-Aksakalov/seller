package com.example.seller.presentation.bottomNav.screen

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.seller.R
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning

@Composable
fun BarCodeScreen() {

    var isClikedBarcode by rememberSaveable { mutableStateOf(false) }
    var isClikedNfc by rememberSaveable { mutableStateOf(false) }
//    var rawValue by rememberSaveable { mutableStateOf<String>("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White),
    ) {

        if (isClikedBarcode) {
//            rawValue = CameraPreview()
            Text(text = CameraPreview())
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
                    .padding(0.dp, 0.dp, 0.dp, 75.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                ExtendedFloatingActionButton(
                    modifier = Modifier.size(width = 160.dp, height = 52.dp),
                    icon = {
                        Icon(
                            painterResource(R.drawable.barcode_btn),
                            contentDescription = "Bar code"
                        )
                    },
                    text = {
                        Text(
                            "Bar code",
                            fontFamily = FontFamily.Default,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.W600,
                            fontSize = 14.sp,
                            lineHeight = 30.sp,
                        )
                    },
                    backgroundColor = if (isClikedBarcode) Color.Black else Color.LightGray,
                    contentColor = if (isClikedBarcode) Color.White else Color.Black,
                    onClick = {
                        isClikedBarcode = true
                        isClikedNfc = false
                    }
                )

                ExtendedFloatingActionButton(
                    modifier = Modifier.size(width = 160.dp, height = 52.dp),
                    icon = {
                        Icon(
                            painterResource(R.drawable.nfc_btn),
                            contentDescription = "NFC"
                        )
                    },
                    text = {
                        Text(
                            "NFC",
                            fontFamily = FontFamily.Default,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.W600,
                            fontSize = 14.sp,
                            lineHeight = 30.sp,
                        )
                    },
                    backgroundColor = if (isClikedNfc) Color.Black else Color.LightGray,
                    contentColor = if (isClikedNfc) Color.White else Color.Black,
                    onClick = {
                        isClikedNfc = true
                        isClikedBarcode = false
                    }
                )
            }
        }

    }
}

@Composable
fun CameraPreview(): String {
    val context = LocalContext.current
    val scanner = GmsBarcodeScanning.getClient(context)
    var rawValue by rememberSaveable { mutableStateOf<String>("") }

    scanner.startScan()
        .addOnSuccessListener { barcode ->
            // Task completed successfully
            rawValue = barcode.rawValue.toString()
        }
        .addOnCanceledListener {
            // Task canceled
        }
        .addOnFailureListener { e ->
            // Task failed with an exception
            rawValue = e.printStackTrace().toString()
        }

    return rawValue;
}

