package com.example.seller.presentation.hoc

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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.seller.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun OtpBottomSheet(withFaceId: Boolean = false) {

    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )

    val pinCodes = rememberMutableStateListOf<String>()

    val table: Array<Array<Int>> = Array(4, { Array(4, { 0 }) })
    table[0] = arrayOf(1, 2, 3)
    table[1] = arrayOf(4, 5, 6)
    table[2] = arrayOf(7, 8, 9)
    table[3] = arrayOf(10, 0, 11)

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            Column(
                content = {

                    Text(
                        text = "Введите код-пароль для входа",
                        fontFamily = FontFamily.Default,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.W500,
                        fontSize = 16.sp,
                        lineHeight = 30.sp,
                        color = colorResource(id = R.color.black2),
                        modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 40.dp, bottom = 32.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        for (i in 0..3) {
                            if (i < pinCodes.size) {
                                Dot(Color.Gray)
                            } else {
                                Dot(Color.LightGray)
                            }
                        }
                    }

                    if (withFaceId) {
                        DigitsFaceId(table = table, pinCodes = pinCodes)
                    } else {
                        Digits(table, pinCodes)
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 45.dp, 0.dp, 0.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Забыли код?",
                            fontFamily = FontFamily.Default,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.W500,
                            fontSize = 16.sp,
                            lineHeight = 30.sp,
                            color = colorResource(id = R.color.black2),
                            modifier = Modifier.clickable(role = Role.Button) {

                            }
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(600.dp)
                    .background(Color.White)
                    .padding(75.dp, 37.dp, 75.dp, 0.dp),
            )
        },
        sheetPeekHeight = 600.dp,
    ) {

        //Add button to open bottom sheet
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(colorResource(id = R.color.background))
                .padding(20.dp)
        ) {
            Text(pinCodes.joinToString { it })
            if (withFaceId) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(R.drawable.rectangle_black),
                            contentDescription = "Profile",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.padding(end = 18.dp)
                        )
                        Text(
                            text = "Александр,\n" +
                                    "Добрый вечер!",
                            fontFamily = FontFamily.Default,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.W700,
                            fontSize = 18.sp,
                            lineHeight = 25.sp,
                            color = colorResource(
                                id = R.color.black2
                            )
                        )
                    }

                    Image(
                        painter = painterResource(R.drawable.logout),
                        contentDescription = "Logout",
                        contentScale = ContentScale.Crop
                    )
                }

            }
        }
    }
}

@Composable
fun Digits(table: Array<Array<Int>>, pinCodes: SnapshotStateList<String>) {
    for (indexA in table) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 39.dp, 0.dp, 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            for (indexB in indexA) {

                if (indexB == 10) {
                    Text(
                        text = indexB.toString(),
                        fontFamily = FontFamily.Default,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.W500,
                        fontSize = 30.sp,
                        lineHeight = 30.sp,
                        color = Color.White,
                        modifier = Modifier
                    )
                }

                if (indexB == 11) {
                    Image(
                        painter = painterResource(R.drawable.remove_box),
                        contentDescription = "Remove pin code",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.clickable {
                            if (pinCodes.size != 0) {
                                pinCodes.remove(
                                    pinCodes.elementAt(
                                        pinCodes.lastIndex
                                    )
                                )
                            }
                        }
                    )
                }

                if (indexB != 10 && indexB != 11) {

                    Text(
                        text = indexB.toString(),
                        fontFamily = FontFamily.Default,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.W500,
                        fontSize = 30.sp,
                        lineHeight = 30.sp,
                        color = colorResource(id = R.color.black2),
                        modifier = Modifier
                            .clickable(role = Role.Button) {
                                if (pinCodes.size < 4) {
                                    pinCodes.add(indexB.toString())
                                }
                            }
                    )
                }
            }
        }
    }
}

@Composable
fun DigitsFaceId(table: Array<Array<Int>>, pinCodes: SnapshotStateList<String>) {
    for (indexA in table) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 39.dp, 0.dp, 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            for (indexB in indexA) {

                if (indexB == 10) {
                    Image(
                        painter = painterResource(R.drawable.face_id),
                        contentDescription = "Face id",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clickable {

                            }
                    )
                }

                if (indexB == 11) {
                    Image(
                        painter = painterResource(R.drawable.remove_box),
                        contentDescription = "Remove pin code",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.clickable {
                            if (pinCodes.size != 0) {
                                pinCodes.remove(
                                    pinCodes.elementAt(
                                        pinCodes.lastIndex
                                    )
                                )
                            }
                        }
                    )
                }

                if (indexB != 10 && indexB != 11) {

                    Text(
                        text = indexB.toString(),
                        fontFamily = FontFamily.Default,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.W500,
                        fontSize = 30.sp,
                        lineHeight = 30.sp,
                        color = colorResource(id = R.color.black2),
                        modifier = Modifier
                            .clickable(role = Role.Button) {
                                if (pinCodes.size < 4) {
                                    pinCodes.add(indexB.toString())
                                }
                            }
                    )
                }
            }
        }
    }
}

@Composable
fun <T : Any> rememberMutableStateListOf(vararg elements: T): SnapshotStateList<T> {
    return rememberSaveable(
        saver = listSaver(
            save = { stateList ->
                if (stateList.isNotEmpty()) {
                    val first = stateList.first()
                    if (!canBeSaved(first)) {
                        throw IllegalStateException("${first::class} cannot be saved. By default only types which can be stored in the Bundle class can be saved.")
                    }
                }
                stateList.toList()
            },
            restore = { it.toMutableStateList() }
        )
    ) {
        elements.toList().toMutableStateList()
    }
}

@Composable
fun Dot(
    color: Color,
) {
    Box(
        modifier = Modifier
            .requiredSize(
                size = 12.dp,
            )
            .background(
                color = color,
                shape = CircleShape,
            ),
    )
}

@Composable
fun FaceId(){
    
}