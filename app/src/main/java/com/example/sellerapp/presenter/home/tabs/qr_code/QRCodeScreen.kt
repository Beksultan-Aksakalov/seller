package com.example.sellerapp.presenter.home.tabs.qr_code

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sellerapp.R
import com.example.sellerapp.core.navigation.NavigationProvider
import com.example.sellerapp.core.navigation.graph.HomeNavGraph
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning
import com.ramcosta.composedestinations.annotation.Destination

@HomeNavGraph
@Destination
@Composable
fun QRCodeScreen(navigator: NavigationProvider) {

    val context = LocalContext.current

    val scanner = GmsBarcodeScanning.getClient(context)

    var isQrCode by rememberSaveable { mutableStateOf(false) }
    var isLoyality by rememberSaveable { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp, start = 20.dp, end = 20.dp),
            verticalArrangement = Arrangement.Bottom
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Button(
                    onClick = {
                        isQrCode = true
                        isLoyality = false

                        scanner.startScan().addOnSuccessListener {
                            isQrCode = false
                            isLoyality = false

                            it.rawValue?.let { it1 -> navigator.openReceiptInfo(it1) }
                                ?: Toast.makeText(context, "Unknown Error", Toast.LENGTH_SHORT)
                                    .show()
                        }.addOnCanceledListener {
                            isQrCode = false
                            isLoyality = false
                        }
                    },
                    modifier = Modifier
                        .height(52.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = if (isQrCode) Color.White else Color.Black,
                        containerColor = if (isQrCode) Color.Black else Color.LightGray
                    ),
                    shape = RoundedCornerShape(80.dp)
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.barcode_botton_nav),
                        contentDescription = "Чек",
                        colorFilter = if (isQrCode) ColorFilter.tint(Color.White) else ColorFilter.tint(
                            Color.Black
                        ),
                        modifier = Modifier.padding(end = 30.dp)
                    )

                    Text(
                        "Чек",
                        fontFamily = FontFamily.Default,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.W600,
                        fontSize = 14.sp,
                        lineHeight = 30.sp,
                    )
                }

                Spacer(modifier = Modifier.weight(0.1f))

                Button(
                    onClick = {
                        isQrCode = false
                        isLoyality = true
                    },
                    modifier = Modifier
                        .height(52.dp)
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = if(isLoyality) Color.White else Color.Black,
                        containerColor = if(isLoyality) Color.Black else Color.LightGray
                    ),
                    shape = RoundedCornerShape(80.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.barcode_botton_nav),
                        contentDescription = "Лояльность",
                        colorFilter = if (isLoyality) ColorFilter.tint(Color.White) else ColorFilter.tint(
                            Color.Black
                        ),
                        modifier = Modifier.padding(end = 5.dp)
                    )

                    Text(
                        "Лояльность",
                        fontFamily = FontFamily.Default,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.W600,
                        fontSize = 13.sp,
                        lineHeight = 25.sp,
                    )
                }
            }
        }
    }
}