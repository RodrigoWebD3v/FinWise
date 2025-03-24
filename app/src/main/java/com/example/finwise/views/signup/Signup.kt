package com.example.finwise.views.signup

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import org.koin.androidx.compose.koinViewModel

@Composable
fun Signup(modifier: Modifier = Modifier, onSigninClick: () -> Unit, onSignupClick: () -> Unit) {

    val viewModel = koinViewModel<SignupViewModel>()

    var isVisible by remember { mutableStateOf(false) }

    val uiState by viewModel.uiState.collectAsState()


    LaunchedEffect(Unit) {
        isVisible = true
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(Caribbean_Green),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(R.string.welcome),
            modifier = Modifier
                .padding(50.dp),
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
                conteudos = listOf(
                {
                    InputText(
                        value = uiState.name,
                        label = stringResource(R.string.fullname),
                        placeholder = "Silverster sta longe",
                        onValueChange = { novoTexto ->
                            uiState.onChangeName(novoTexto)
                        })

                    InputText(
                        value = uiState.email,
                        label = stringResource(R.string.email),
                        placeholder = "exemple@gmail.com",
                        keyboardType = KeyboardType.Email,
                        onValueChange = { novoTexto ->
                            uiState.onChangeEmail(novoTexto)
                        })

                    InputText(
                        value = uiState.mobileNumber,
                        label = stringResource(R.string.mobilenumber),
                        placeholder = "+123 456 789",
                        keyboardType = KeyboardType.Phone,
                        onValueChange = { novoTexto ->
                            uiState.onChangeMobileNumber(novoTexto)
                        })
                    InputText(
                        value = uiState.dateOfBirth,
                        label = stringResource(R.string.dateofbirth),
                        placeholder = "DD/MM/YYYY",
                        keyboardType = KeyboardType.Number,
                        onValueChange = { novoTexto ->
                            uiState.onChangeDateOfBirth(novoTexto)
                        })

                    InputTextPassword(
                        value = uiState.password,
                        label = stringResource(R.string.password),
                        placeholder = "***********",
                        onValueChange = { novoTexto ->
                            uiState.onChangePassword(novoTexto)
                        })

                    InputTextPassword(
                        value = uiState.confirmPassword,
                        label = stringResource(R.string.confirmpassword),
                        placeholder = "***********",
                        onValueChange = { novoTexto ->
                            uiState.onChangeConfirmPassword(novoTexto)
                        })

                    Text(
                        text = stringResource(R.string.terms),
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_medium)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF4B4544),
                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier
                            .fillMaxWidth(0.6f)
                            .padding(vertical = 15.dp)
                    )

                    Button(
                        onClick = {
                            onSignupClick()
                        },
                        modifier = Modifier.fillMaxWidth(0.5f),
                        colors = ButtonDefaults.buttonColors(containerColor = Caribbean_Green)
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

                    Row {
                        Text(
                            stringResource(R.string.alreadyhaveanaccount),
                            style = TextStyle(
                                fontSize = 13.sp,
                                lineHeight = 15.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                color = TextGreen,
                                textAlign = TextAlign.Center,
                            )
                        )

                        Text(
                            stringResource(R.string.signIn),
                            style = TextStyle(
                                fontSize = 13.sp,
                                lineHeight = 15.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                                color = Color(0xff0774fe),
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier.clickable {
                                onSigninClick()
                            }
                        )
                    }
                }
            ))
        }
    }
}

@Preview
@Composable
private fun SignupPrev() {
    Signup(
        onSigninClick = {},
        onSignupClick = {}
    )
}