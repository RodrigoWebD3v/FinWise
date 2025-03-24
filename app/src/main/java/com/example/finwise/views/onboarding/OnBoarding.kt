package com.example.finwise.views.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finwise.R
import com.example.finwise.ui.theme.Caribbean_Green
import com.example.finwise.ui.theme.Fence_Green
import com.example.finwise.ui.theme.Light_Green
import com.example.finwise.ui.theme.TextGreen
import com.example.finwise.views.sharedComponents.BackGround
import com.example.finwise.views.sharedComponents.ButtonTheme

@Composable
fun OnBoarding(modifier: Modifier = Modifier, onConfirmClick: () -> Unit) {
    val pagerState = rememberPagerState(pageCount = {
        2
    })
    var buttonConfirmVisible  by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Caribbean_Green),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Spacer(Modifier.size(30.dp))

        Text(
            text = stringResource(if(pagerState.currentPage == 0) R.string.onboarding else R.string.onboarding_two),
            style = TextStyle(
                fontSize = 30.sp,
                lineHeight = 39.sp,
                fontFamily = FontFamily(Font(R.font.poppins_bold)),
                color = TextGreen,
                textAlign = TextAlign.Center,
            )
        )

        BackGround(
            modifier.fillMaxHeight(.7f).fillMaxWidth(),
            conteudos = listOf {
                Spacer(Modifier.size(100.dp))

                HorizontalPager(pagerState) { page ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            contentAlignment = Alignment.Center
                        ) {
                            Box(
                                Modifier
                                    .size(150.dp)
                                    .clip(CircleShape)
                                    .background(Light_Green)
                            )
                            if (page == 0) {
                                Image(
                                    painter = painterResource(id = R.drawable.mao_moeda),
                                    contentDescription = "Hand and Coin",
                                    modifier = Modifier.size(150.dp)
                                )
                            } else {
                                buttonConfirmVisible = true
                                Image(
                                    painter = painterResource(id = R.drawable.touch_celular),
                                    contentDescription = "playing cell phone",
                                    modifier = Modifier.size(150.dp)
                                )
                            }
                        }

                        Spacer(Modifier.fillMaxSize(.2f))

                    }
                }

                Spacer(Modifier.size(100.dp))

                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(10.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Box(
                        Modifier
                            .size(10.dp)
                            .clip(CircleShape)
                            .background(if (pagerState.targetPage == 0) Caribbean_Green else Color.Transparent)
                            .border(width = 1.dp, color = if(pagerState.targetPage == 0) Caribbean_Green else Fence_Green, shape = CircleShape)
                    )
                    Spacer(Modifier.fillMaxSize(.020f))

                    Box(
                        Modifier
                            .size(10.dp)
                            .clip(CircleShape)
                            .background(if (pagerState.targetPage == 1) Caribbean_Green else Color.Transparent)
                            .border(width = 1.dp, color = if(pagerState.targetPage == 1) Caribbean_Green else Fence_Green, shape = CircleShape)
                    )
                }

                if(buttonConfirmVisible){
                    Box(
                        Modifier.weight(1f).fillMaxWidth().padding(bottom = 20.dp),
                        contentAlignment = Alignment.BottomCenter
                    ){
                        ButtonTheme(
                            text = "teste",
                            onClickfather = {
                                onConfirmClick()
                            }
                        )
                    }
                }
            }
        )

    }
}

@Preview
@Composable
private fun OnBoardingPrev() {
    OnBoarding(onConfirmClick = { })
}