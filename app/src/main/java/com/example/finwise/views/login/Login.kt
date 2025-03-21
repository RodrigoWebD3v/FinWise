package com.example.finwise.views.login

import android.widget.ImageView
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.material3.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.material.icons.filled.GMobiledata
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.Label
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.finwise.ui.theme.Light_Green
import com.example.finwise.ui.theme.TextGreen
import com.example.finwise.views.sharedComponents.LoginSignup

@Composable
fun Login(modifier: Modifier = Modifier) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var isVisible by remember { mutableStateOf(false) }

    var isPasswordVisible by remember { mutableStateOf(false) }

    val offsetY by animateDpAsState(
        targetValue = if (isVisible) (-10).dp else 0.dp,
        animationSpec = tween(durationMillis = 3000)
    )

    LaunchedEffect(Unit) {
        isVisible = true
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(Caribbean_Green),
        horizontalAlignment = Alignment.CenterHorizontally
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
                        .fillMaxSize()
                        .padding(top = 60.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        Modifier.padding(top = 80.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Column {
                            Text(
                                stringResource(R.string.usernameoremail), style = TextStyle(
                                    fontSize = 15.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                                    fontWeight = FontWeight(500),
                                    color = TextGreen,
                                    ),
                                modifier = Modifier.padding(start = 20.dp)
                            )
                            TextField(
                                value = email,
                                onValueChange = { email = it },
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
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Email,
                                        contentDescription =stringResource(R.string.emailIcon),
                                        tint = Color.Gray
                                    )
                                },
                                modifier = Modifier
                                    .fillMaxWidth(0.8f)

                            )

                        }

                        Spacer(Modifier.size(30.dp))

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
                                value = password,
                                onValueChange = { password = it },
                                placeholder = { Text("********") },
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

                        Spacer(Modifier.size(70.dp))

                        LoginSignup(
                            onLoginClick = { },
                            onSignupClick = { },
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
                                )
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
private fun LoginPreview() {

    Login(

    )
}