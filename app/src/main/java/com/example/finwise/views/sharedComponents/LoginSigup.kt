package com.example.finwise.views.sharedComponents

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
import com.example.finwise.ui.theme.Caribbean_Green

@Composable
fun LoginSignup(modifier: Modifier = Modifier,isLogin : Boolean = false,onLoginClick: () -> Unit, onSignupClick: () -> Unit, ) {
    Button(
        onClick = onLoginClick,
        modifier = Modifier.fillMaxWidth(0.5f),
        colors = ButtonDefaults.buttonColors(containerColor = Caribbean_Green)
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

    if(!isLogin) Spacer(modifier.height(10.dp)) else Text(stringResource(R.string.forgotPassowrd),
        Modifier.padding(vertical = 10.dp),
        style = TextStyle(
        fontSize = 14.sp,
        fontFamily = FontFamily(Font(R.font.poppins_medium)),
        fontWeight = FontWeight(600),
        color = Color(0xFF093030),
        textAlign = TextAlign.Center,
    ))

    Button(
        onClick = onSignupClick,
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
}

@Preview
@Composable
private fun LoginSignupPrev() {
    LoginSignup(onSignupClick = {}, onLoginClick = {}, isLogin = false)
}