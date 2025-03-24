package com.example.finwise.views.sharedComponents.ItemListHistory

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finwise.R
import com.example.finwise.ui.theme.Caribbean_Green
import com.example.finwise.ui.theme.TextGreen

@Composable
fun ItemListHistory(modifier: Modifier = Modifier, category: String, value: String, icon: Int) {
    Row (
        modifier.fillMaxWidth(.8f).fillMaxHeight().padding(top = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){

        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
        )

        Column {
            Text(
                text = "Salary",

                // Subtitle
                style = TextStyle(
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    color = TextGreen,
                )
            )

            Text(
                text = "18:27 - April 30",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = Color(0xFF0068FF),
                )
            )

        }
        VerticalDivider(
            modifier = Modifier.height(30.dp).width(2.dp).background(Caribbean_Green),
        )

        Column {
            Text(
                text = category,

                // Subtitle
                style = TextStyle(
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_light)),
                    color = TextGreen,
                )
            )
        }

        VerticalDivider(
            modifier = Modifier.height(30.dp).width(2.dp).background(Caribbean_Green),
        )

        Column {
            Text(
                text = value,

                style = TextStyle(
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    color = TextGreen,
                )
            )
        }

    }
}

@Preview
@Composable
private fun ItemListHistoryPrev() {
    ItemListHistory(
        category = "Monthly",
        value = "R$ 1.000,00",
        icon = R.drawable.icon_salary_blue
    )
}