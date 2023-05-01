package com.example.seller.presentation.screen.onboarding

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.seller.R
import com.example.seller.route.Routes


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoarding(navController: NavController) {

    val viewModel: OnBoardingViewModel = viewModel()
    val items by viewModel.state.observeAsState(emptyList())

    val pageCount = items.size
    val pagerState = rememberPagerState()

    Log.d("ITEMS", items.joinToString())

    Box(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            pageCount = pageCount,
            state = pagerState
        ) { page ->
            // Our page content

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(Color.White)
            ) {

                Image(
                    painter = painterResource(R.drawable.on_boarding),
                    contentDescription = "On boarding image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 50.dp, 0.dp, 0.dp)
                )

                Text(
                    text = ("Одно решение\n" + "для быстрой оплаты").uppercase(),
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(0.dp, 31.dp, 0.dp, 0.dp),
                    fontFamily = FontFamily.Default,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.W800,
                    fontSize = 24.sp,
                    lineHeight = 30.sp,
                    color = colorResource(id = R.color.black1),
                    textAlign = TextAlign.Center,
                )

                Text(
                    text = "Оплачивай покупки не подходя к кассе",
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(0.dp, 16.dp, 0.dp, 0.dp),
                    fontFamily = FontFamily.Default,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.W400,
                    fontSize = 16.sp,
                    lineHeight = 30.sp,
                    color = colorResource(id = R.color.black2),
                    textAlign = TextAlign.Center
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 90.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.Center
        ) {
//            Button(
//                onClick = { navController.navigate(route = Routes.REGISTRATION_PHONE.name) },
//                modifier = Modifier
//                    .size(175.dp, 52.dp),
//                colors = ButtonDefaults.buttonColors(
//                    contentColor = Color.White, containerColor = Color.Black
//                ),
//                shape = RoundedCornerShape(80.dp)
//
//            ) {
//                Text(text = "Войти")
//            }
        }

        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
                .align(Alignment.TopCenter),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            repeat(pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) Color.Black else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .background(color)
                        .weight(0.1f)
                        .height(4.dp)
                )
            }
        }
    }


    ///////////////

//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .fillMaxHeight()
//            .background(Color.White)
//    ) {
//
//        Image(
//            painter = painterResource(R.drawable.on_boarding),
//            contentDescription = "On boarding image",
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(0.dp, 50.dp, 0.dp, 0.dp)
//        )
//
//        Text(
//            text = ("Одно решение\n" + "для быстрой оплаты").uppercase(),
//            modifier = Modifier
//                .fillMaxWidth(1f)
//                .padding(0.dp, 31.dp, 0.dp, 0.dp),
//            fontFamily = FontFamily.Default,
//            fontStyle = FontStyle.Normal,
//            fontWeight = FontWeight.W800,
//            fontSize = 24.sp,
//            lineHeight = 30.sp,
//            color = colorResource(id = R.color.black1),
//            textAlign = TextAlign.Center,
//        )
//
//        Text(
//            text = "Оплачивай покупки не подходя к кассе",
//            modifier = Modifier
//                .fillMaxWidth(1f)
//                .padding(0.dp, 16.dp, 0.dp, 0.dp),
//            fontFamily = FontFamily.Default,
//            fontStyle = FontStyle.Normal,
//            fontWeight = FontWeight.W400,
//            fontSize = 16.sp,
//            lineHeight = 30.sp,
//            color = colorResource(id = R.color.black2),
//            textAlign = TextAlign.Center
//        )
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(0.dp, 39.dp, 0.dp, 0.dp),
//            horizontalArrangement = Arrangement.Center
//        ) {
//            Button(
//                onClick = { navController.navigate(route = Routes.REGISTRATION_PHONE.name) },
//                modifier = Modifier
//                    .size(175.dp, 52.dp),
//                colors = ButtonDefaults.buttonColors(
//                    contentColor = Color.White, containerColor = Color.Black
//                ),
//                shape = RoundedCornerShape(80.dp)
//
//            ) {
//                Text(text = "Войти")
//            }
//        }
//
//    }
}