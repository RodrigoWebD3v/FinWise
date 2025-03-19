package com.example.finwise.views.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
import androidx.compose.foundation.layout.Arrangement

@Composable
fun Login(modifier: Modifier = Modifier, paddingValues: PaddingValues) {
    Column(Modifier.fillMaxSize().background(Caribbean_Green),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = stringResource(R.string.welcome),
            modifier = Modifier
                .padding(60.dp),
            style = TextStyle(
                fontSize = 25.sp,
                lineHeight = 22.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                color = Color(0xFF093030),
                textAlign = TextAlign.Center,
            )
        )
        Box(contentAlignment = Alignment.BottomEnd){

            Image(
                painter = painterResource(id = R.drawable.base_shape),
                contentDescription = "Background column",
            )

            Column (
                Modifier.fillMaxSize().padding(top = 60.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ){

            }
        }

    }
}

@Preview
@Composable
private fun LoginPreview() {
    Scaffold {
        innerPadding ->
        Login(
            paddingValues = innerPadding
        )
    }
}