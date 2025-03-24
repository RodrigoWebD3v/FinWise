package com.example.finwise.views.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finwise.R
import com.example.finwise.ui.theme.Caribbean_Green
import com.example.finwise.ui.theme.TextGreen
import com.example.finwise.views.sharedComponents.BackGround
import com.example.finwise.views.sharedComponents.InputText
import com.example.finwise.views.sharedComponents.InputTextPassword
import com.example.finwise.views.sharedComponents.LoginSignup
import org.koin.androidx.compose.koinViewModel

@Composable
fun Login(modifier: Modifier = Modifier, onSignupClick: () -> Unit, onHomeClick: () -> Unit) {

    val viewModel = koinViewModel<LoginViewModel>()

    val uiState by viewModel.uiState.collectAsState()

    var isVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        isVisible = true
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(Caribbean_Green),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(R.string.welcome),
            modifier = Modifier
                .padding(50.dp).weight(1f),
            style = TextStyle(
                fontSize = 25.sp,
                lineHeight = 22.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                color = TextGreen,
                textAlign = TextAlign.Center,
            )
        )
        AnimatedVisibility(
            visible = isVisible,
            enter = slideInVertically(
                initialOffsetY = { it },
                animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
            ) + fadeIn(),
            exit = fadeOut(),

            ) {

            BackGround(
                modifier.fillMaxHeight(.8f).fillMaxWidth(),
                conteudos = listOf {
                    Column(
                        Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {

                        InputText(
                            value = uiState.email,
                            label = stringResource(R.string.usernameoremail),
                            placeholder = "exemple@gmail.com",
                            keyboardType = KeyboardType.Email,
                            onValueChange = { novoTexto ->
                                uiState.onChangeEmail(novoTexto)
                            })

                        Spacer(Modifier.size(30.dp))

                        InputTextPassword(
                            value = uiState.password,
                            label = stringResource(R.string.password),
                            placeholder = "***********",
                            onValueChange = { novoTexto ->
                                uiState.onChangePassword(novoTexto)
                            })

                        Spacer(Modifier.size(70.dp))

                        LoginSignup(
                            onLoginClick = {
                                onHomeClick()
                            },
                            onSignupClick = {
                                onSignupClick()
                            },
                            isLogin = true
                        )

                        Row(
                            Modifier
                                .fillMaxWidth(0.5f)
                                .padding(vertical = 15.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = stringResource(R.string.Use),
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    lineHeight = 22.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                    fontWeight = FontWeight(600),
                                    color = TextGreen,
                                    textAlign = TextAlign.Center,
                                )
                            )

                            Spacer(Modifier.width(5.dp))

                            Text(
                                text = stringResource(R.string.fingerprint),
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    lineHeight = 22.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                    fontWeight = FontWeight(600),
                                    color = Color(0xff0774fe),
                                    textAlign = TextAlign.Center,
                                )
                            )

                            Spacer(Modifier.width(5.dp))

                            Text(
                                text = stringResource(R.string.toaccess),
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    lineHeight = 22.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                    fontWeight = FontWeight(600),
                                    color = TextGreen,
                                    textAlign = TextAlign.Center,
                                )
                            )
                        }

                        Text(
                            text = stringResource(R.string.orsignupwith),

                            style = TextStyle(
                                fontSize = 13.sp,
                                lineHeight = 15.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_light)),
                                fontWeight = FontWeight(300),
                                color = TextGreen,
                                textAlign = TextAlign.Center,
                            )
                        )

                        Row(
                            Modifier
                                .fillMaxWidth(0.5f)
                                .padding(vertical = 20.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.facebook),
                                contentDescription = "Facebook logo",
                                modifier = Modifier.size(40.dp),
                                contentScale = ContentScale.Fit
                            )

                            Spacer(Modifier.size(15.dp))

                            Image(
                                painter = painterResource(id = R.drawable.google),
                                contentDescription = "Google logo",
                                modifier = Modifier.size(40.dp),
                                contentScale = ContentScale.Fit
                            )
                        }

                        Row {
                            Text(
                                stringResource(R.string.donthaveanaccount),
                                style = TextStyle(
                                    fontSize = 13.sp,
                                    lineHeight = 15.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                    color = TextGreen,
                                    textAlign = TextAlign.Center,
                                )
                            )
                            Spacer(Modifier.size(5.dp))
                            Text(
                                stringResource(R.string.signup),
                                style = TextStyle(
                                    fontSize = 13.sp,
                                    lineHeight = 15.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                                    color = Color(0xff0774fe),
                                    textAlign = TextAlign.Center,
                                ),
                                modifier = Modifier.clickable {
                                    onSignupClick()
                                }
                            )
                        }
                    }
                }
            )
        }
    }
}

@Preview
@Composable
private fun LoginPreview() {

    Login(
        onSignupClick = {},
        onHomeClick = {}
    )
}