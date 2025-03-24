package com.example.finwise.views.sharedComponents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.finwise.R
import com.example.finwise.ui.theme.Caribbean_Green
import com.example.finwise.ui.theme.TextGreen

@Composable
fun ButtonTheme(
    modifier: Modifier = Modifier,
    color: Color = Caribbean_Green,
    text: String,
    textColor: Color = TextGreen,
    onClickfather: () -> Unit
) {

    Button(
        onClick = onClickfather,
        modifier = Modifier.fillMaxWidth(0.5f),
        colors = ButtonDefaults.buttonColors(containerColor = color)
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 22.sp,
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                color = textColor,
                textAlign = TextAlign.Center,
            )
        )
    }

}

@Preview
@Composable
private fun ButtonThemePrev() {
    Box(Modifier.fillMaxSize()){
        ButtonTheme(text = "aabbs", onClickfather = {})
    }
}