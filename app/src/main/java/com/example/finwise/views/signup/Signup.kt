package com.example.finwise.views.signup

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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finwise.R
import com.example.finwise.ui.theme.Caribbean_Green
import com.example.finwise.ui.theme.Light_Green
import com.example.finwise.ui.theme.TextGreen
import com.example.finwise.views.sharedComponents.LoginSignup
import org.koin.androidx.compose.koinViewModel

@Composable
fun Signup(modifier: Modifier = Modifier, onSigninClick : () -> Unit) {

   val viewModel = koinViewModel<SignupViewModel>()

    var isVisible by remember { mutableStateOf(false) }

    var isPasswordVisible by remember { mutableStateOf(false) }

    var isConfirmPasswordVisible by remember { mutableStateOf(false) }

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
            enter = slideInVertically(initialOffsetY = { it },  animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)) + fadeIn(),
            exit = fadeOut(),
            ) {
            Box(contentAlignment = Alignment.BottomEnd) {
                Image(
                    painter = painterResource(id = R.drawable.base_shape),
                    contentDescription = "Background column",
                )

                Column(
                    Modifier
                        .fillMaxWidth().fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Column(
                        Modifier
                            .fillMaxHeight(0.9f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        Column {
                            Text(
                                stringResource(R.string.fullname), style = TextStyle(
                                    fontSize = 15.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                                    fontWeight = FontWeight(500),
                                    color = TextGreen,
                                ),
                                modifier = Modifier.padding(start = 20.dp)
                            )
                            TextField(
                                value = uiState.email,
                                onValueChange = { uiState.onChangeEmail(it) },
                                placeholder = { Text("Silvester Stalonge") },
                                shape = RoundedCornerShape(30.dp),
                                colors = TextFieldDefaults.colors(
                                    unfocusedContainerColor = Light_Green,
                                    focusedContainerColor = Light_Green,
                                    cursorColor = Color.Black,
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent
                                ),

                                textStyle = TextStyle(color = Color.Black),
                                singleLine = true,
                                modifier = Modifier
                                    .fillMaxWidth(0.8f).padding(0.3.dp),


                            )
                        }

                        Column {
                            Text(
                                stringResource(R.string.email), style = TextStyle(
                                    fontSize = 15.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                                    fontWeight = FontWeight(500),
                                    color = TextGreen,
                                ),
                                modifier = Modifier.padding(start = 20.dp)
                            )
                            TextField(
                                value = uiState.email,
                                onValueChange = { uiState.onChangeEmail(it) },
                                placeholder = { Text("example@example.com") },
                                shape = RoundedCornerShape(30.dp),
                                colors = TextFieldDefaults.colors(
                                    unfocusedContainerColor = Light_Green,
                                    focusedContainerColor = Light_Green,
                                    cursorColor = Color.Black,
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent
                                ),
                                textStyle = TextStyle(color = Color.Black),
                                singleLine = true,
                                modifier = Modifier
                                    .fillMaxWidth(0.8f)
                            )

                        }

                        Column {
                            Text(
                                stringResource(R.string.mobilenumber), style = TextStyle(
                                    fontSize = 15.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                                    fontWeight = FontWeight(500),
                                    color = TextGreen,
                                ),
                                modifier = Modifier.padding(start = 20.dp)
                            )
                            TextField(
                                value = uiState.mobileNumber,
                                onValueChange = { uiState.onChangeMobileNumber(it) },
                                placeholder = { Text("+123 456 789") },
                                shape = RoundedCornerShape(30.dp),
                                colors = TextFieldDefaults.colors(
                                    unfocusedContainerColor = Light_Green,
                                    focusedContainerColor = Light_Green,
                                    cursorColor = Color.Black,
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent
                                ),
                                textStyle = TextStyle(color = Color.Black),
                                singleLine = true,
                                modifier = Modifier
                                    .fillMaxWidth(0.8f)
                            )

                        }

                        Column {
                            Text(
                                stringResource(R.string.dateofbirth), style = TextStyle(
                                    fontSize = 15.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                                    fontWeight = FontWeight(500),
                                    color = TextGreen,
                                ),
                                modifier = Modifier.padding(start = 20.dp)
                            )
                            TextField(
                                value = uiState.dateOfBirth,
                                onValueChange = { uiState.onChangeDateOfBirth(it) },
                                placeholder = { Text("DD/MM/YYYY") },
                                shape = RoundedCornerShape(30.dp),
                                colors = TextFieldDefaults.colors(
                                    unfocusedContainerColor = Light_Green,
                                    focusedContainerColor = Light_Green,
                                    cursorColor = Color.Black,
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent
                                ),
                                textStyle = TextStyle(color = Color.Black),
                                singleLine = true,
                                modifier = Modifier
                                    .fillMaxWidth(0.8f)
                            )

                        }

                        Column {
                            Text(
                                stringResource(R.string.password), style = TextStyle(
                                    fontSize = 15.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                                    fontWeight = FontWeight(500),
                                    color = TextGreen,
                                ),
                                modifier = Modifier.padding(start = 20.dp)
                            )
                            TextField(
                                value = uiState.password,
                                onValueChange = { uiState.onChangePassword(it) },
                                placeholder = { Text("***********") },
                                shape = RoundedCornerShape(30.dp),
                                colors = TextFieldDefaults.colors(
                                    unfocusedContainerColor = Light_Green,
                                    focusedContainerColor = Light_Green,
                                    cursorColor = Color.Black,
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent
                                ),
                                trailingIcon = {
                                    Icon(
                                        imageVector = if(!isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                        contentDescription = stringResource(R.string.togglepasswordvisibility),
                                        tint = Color.Gray,
                                        modifier = Modifier.clickable {
                                            isPasswordVisible = !isPasswordVisible
                                        }
                                    )
                                },
                                textStyle = TextStyle(color = Color.Black),
                                visualTransformation = if(!isPasswordVisible) PasswordVisualTransformation() else VisualTransformation.None,
                                keyboardOptions = KeyboardOptions(keyboardType = if(!isPasswordVisible) KeyboardType.Password else KeyboardType.Text),

                                singleLine = true,
                                modifier = Modifier
                                    .fillMaxWidth(0.8f)
                            )

                        }

                        Column {
                            Text(
                                stringResource(R.string.confirmpassword), style = TextStyle(
                                    fontSize = 15.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                                    fontWeight = FontWeight(500),
                                    color = TextGreen,
                                ),
                                modifier = Modifier.padding(start = 20.dp)
                            )
                            TextField(
                                value = uiState.confirmPassword,
                                onValueChange = { uiState.onChangeConfirmPassword(it) },
                                placeholder = { Text("***********") },
                                shape = RoundedCornerShape(30.dp),
                                colors = TextFieldDefaults.colors(
                                    unfocusedContainerColor = Light_Green,
                                    focusedContainerColor = Light_Green,
                                    cursorColor = Color.Black,
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent
                                ),
                                trailingIcon = {
                                    Icon(
                                        imageVector = if(!isConfirmPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                        contentDescription = stringResource(R.string.togglepasswordvisibility),
                                        tint = Color.Gray,
                                        modifier = Modifier.clickable {
                                            isConfirmPasswordVisible = !isConfirmPasswordVisible
                                        }
                                    )
                                },
                                textStyle = TextStyle(color = Color.Black),
                                visualTransformation = if(!isConfirmPasswordVisible) PasswordVisualTransformation() else VisualTransformation.None,
                                keyboardOptions = KeyboardOptions(keyboardType = if(!isConfirmPasswordVisible) KeyboardType.Password else KeyboardType.Text),
                                singleLine = true,
                                modifier = Modifier
                                    .fillMaxWidth(0.8f)
                            )

                        }

                        Text(
                            text = stringResource(R.string.terms),
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF4B4544),
                                textAlign = TextAlign.Center,
                            ),
                            modifier = Modifier.fillMaxWidth(0.6f).padding(vertical = 15.dp)
                        )

                        Button(
                            onClick = {

                            },
                            modifier = Modifier.fillMaxWidth(0.5f),
                            colors = ButtonDefaults.buttonColors(containerColor = LightGray)
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
                }
            }
        }
    }
}

@Preview
@Composable
private fun SignupPrev() {
    Signup(
        onSigninClick = {}
    )
}