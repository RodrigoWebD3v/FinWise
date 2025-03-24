package com.example.finwise.views.sharedComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finwise.R
import com.example.finwise.ui.theme.Brown
import com.example.finwise.ui.theme.TextGreen

@Composable
fun BackGround(modifier: Modifier = Modifier, conteudos: List<@Composable () -> Unit>) {
    val scrollState = rememberScrollState()

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
            .background(Color.White),
        contentAlignment = Alignment.BottomCenter,

        ) {

        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.95f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Column(
                Modifier
                    .fillMaxSize(.99f)
                    .verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                conteudos.forEach { conteudo ->
                    conteudo()
                    Spacer(modifier = Modifier.height(4.dp))
                }

            }
        }
    }
}

@Preview
@Composable
private fun BackGroundPrev() {
    BackGround(
        conteudos = listOf {
            Column(
                Modifier
                    .background(Color.Red)
                    .height(1000.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.terms), style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontWeight = FontWeight(400),
                        color = Brown,
                        textAlign = TextAlign.Center,
                    ), modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .padding(vertical = 15.dp)
                )

                Button(
                    onClick = {

                    },
                    modifier = Modifier.fillMaxWidth(0.5f),
                    colors = ButtonDefaults.buttonColors(containerColor = LightGray)
                ) {
                    Text(
                        text = stringResource(R.string.signup), style = TextStyle(
                            fontSize = 22.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF4B4544),
                            textAlign = TextAlign.Center,
                        )
                    )
                }

                Row {
                    Text(
                        stringResource(R.string.alreadyhaveanaccount), style = TextStyle(
                            fontSize = 13.sp,
                            lineHeight = 15.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_medium)),
                            color = TextGreen,
                            textAlign = TextAlign.Center,
                        )
                    )

                    Text(
                        stringResource(R.string.signIn), style = TextStyle(
                            fontSize = 13.sp,
                            lineHeight = 15.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                            color = Color(0xff0774fe),
                            textAlign = TextAlign.Center,
                        ), modifier = Modifier.clickable {

                        })
                }
            }
        })
}