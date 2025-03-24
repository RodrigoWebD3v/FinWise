package com.example.finwise.views.sharedComponents

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finwise.R
import com.example.finwise.ui.theme.Caribbean_Green
import com.example.finwise.ui.theme.Light_Green
import com.example.finwise.ui.theme.TextGreen

@Composable
fun FiltroText(modifier: Modifier = Modifier, listaOpcoes: List<String>) {

    var selectedFilter by remember { mutableStateOf(listaOpcoes.first()) }

    Row(
        modifier
            .fillMaxWidth(.8f)
            .clip(RoundedCornerShape(20.dp))
            .height(60.dp)
            .background(Light_Green),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {

        listaOpcoes.forEachIndexed{ index , text ->

            Spacer(modifier = Modifier.width(8.dp))

            val backgroundColor by animateColorAsState(
                targetValue = if (selectedFilter == text) Caribbean_Green else Color.Transparent,
                animationSpec = tween(durationMillis = 600)
            )

            val textColor by animateColorAsState(
                targetValue = if (selectedFilter == text) TextGreen else Color.Gray,
                animationSpec = tween(durationMillis = 600)
            )

            Box(
                Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(19.dp))
                    .background(backgroundColor)
                    .clickable { selectedFilter = text }
                    .padding(10.dp),

                contentAlignment = Alignment.Center
            ) {
                Text(
                    text,
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_light)),
                        fontWeight = FontWeight(400),
                        color = textColor,
                        textAlign = TextAlign.Center,
                    )
                )
            }

            if(index > 1) {
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}