package com.example.finwise.views.launch

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.res.painterResource
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
import com.example.finwise.ui.theme.Caribbean_Green
import com.example.finwise.ui.theme.Honeydew

@Composable
fun Launch(modifier: Modifier = Modifier, paddingValues: PaddingValues) {
    var isVisible by remember { mutableStateOf(false) }

    val offsetY by animateDpAsState(
        targetValue = if (isVisible) (-10).dp else 0.dp,
        animationSpec = tween(durationMillis = 1000)
    )

    val backgroundColor by animateColorAsState(
        targetValue = if (isVisible) Honeydew else Caribbean_Green, // Azul claro para azul médio
        animationSpec = tween(durationMillis = 1000)
    )

    val textColor by animateColorAsState(
        targetValue = if (isVisible) Caribbean_Green else Honeydew, // Azul claro para azul médio
        animationSpec = tween(durationMillis = 1000)
    )

    Column(
        Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .clickable {
                isVisible = !isVisible
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .offset(y = offsetY),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.fin_wise_logo),
                contentDescription = "Fin Wise Logo",
            )
            Text(
                text = "FinWise",
                style = TextStyle(
                    fontSize = 53.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    color = textColor,
                    textAlign = TextAlign.Center,
                )
            )
        }
        AnimatedVisibility(
            visible = isVisible
        ) {
            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod. ",
                    Modifier.fillMaxWidth(0.7f),
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF4B4544),
                        textAlign = TextAlign.Center,
                    )
                )

                Spacer(
                    Modifier.height(30.dp)
                )

                Button(
                    {},
                    Modifier.fillMaxWidth(0.5f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Caribbean_Green // Cor do botão
                    )
                ) {
                    Text(
                        text = stringResource(R.string.login),
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF4B4544),
                            textAlign = TextAlign.Center,
                        )
                    )
                }

                Spacer(
                    Modifier.height(10.dp)
                )

                Button(
                    {},
                    Modifier.fillMaxWidth(0.5f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = LightGray // Cor do botão
                    )
                ) {
                    Text(
                        text = stringResource(R.string.signup),
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF4B4544),
                            textAlign = TextAlign.Center,
                        )
                    )
                }
            }
        }
    }
}


@Preview
@Composable
private fun LaunchPrev() {
    Scaffold { innerPadding ->
        Launch(
            paddingValues = innerPadding,
        )
    }

}