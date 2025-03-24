package com.example.finwise.views.home


import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.TrendingDown
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
import com.example.finwise.ui.theme.Fence_Green
import com.example.finwise.ui.theme.Honeydew
import com.example.finwise.ui.theme.Light_Green
import com.example.finwise.ui.theme.Ocean_Blue
import com.example.finwise.ui.theme.TextGreen
import com.example.finwise.views.sharedComponents.BackGround
import com.example.finwise.views.sharedComponents.CircularProgressWithImage
import com.example.finwise.views.sharedComponents.FiltroText
import com.example.finwise.views.sharedComponents.ItemListHistory.ItemListHistory
import com.example.finwise.views.sharedComponents.ItemListHistory.listaItemListHistory

@Composable
fun Home(modifier: Modifier = Modifier) {


    var expanded by remember { mutableStateOf(true) }

    val widthFraction by animateFloatAsState(
        targetValue = if (expanded) 0.8f else 0f, animationSpec = tween(durationMillis = 1300)
    )

    val widthFractionSavingGoals by animateFloatAsState(
        targetValue = if (expanded) 0.8f else 0f, animationSpec = tween(durationMillis = 1300)
    )


//    LaunchedEffect(Unit) {
//        expanded = true
//    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Caribbean_Green)
    ) {
        Column(
            Modifier.weight(1f)
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(25.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Hi, Welcome Back", style = TextStyle(
                            fontSize = 20.sp,
                            lineHeight = 22.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                            color = TextGreen,
                        )
                    )

                    Text(
                        text = "Good Morning", style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.leaguespartan_medium)),
                            color = Color(0xFF052224),
                        )
                    )
                }

                Box(
                    Modifier
                        .clip(shape = RoundedCornerShape(20.dp))
                        .background(Light_Green)
                        .size(30.dp), contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.NotificationsNone,
                        contentDescription = "notifications",
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp)
                    .padding(bottom = 20.dp), horizontalArrangement = Arrangement.SpaceAround
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.TrendingUp,
                            contentDescription = "notifications",
                        )
                        Text(
                            text = "Total Balance", style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                color = TextGreen,
                            )
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "$7,783.00", style = TextStyle(
                                fontSize = 24.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_extrabold)),
                                color = Honeydew,
                            )
                        )
                    }
                }

                VerticalDivider(
                    Modifier
                        .height(55.dp)
                        .background(Light_Green)
                )

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.TrendingDown,
                            contentDescription = "notifications",
                        )
                        Text(
                            text = "Total Expense", style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                color = TextGreen,
                            )
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = "-$1.187.40", style = TextStyle(
                                fontSize = 24.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_extrabold)),
                                color = Ocean_Blue,
                            )
                        )
                    }
                }
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .height(27.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Row(
                    Modifier
                        .fillMaxWidth(.9f)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(16.dp))
                        .background(Fence_Green),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "30%", style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_medium)),
                            fontWeight = FontWeight(400),
                            color = Honeydew,
                        ), modifier = Modifier.padding(end = 10.dp)
                    )

                    Box(
                        Modifier
                            .fillMaxWidth(widthFraction)
                            .fillMaxHeight()
                            .clip(RoundedCornerShape(16.dp))
                            .background(Honeydew),
                    ) {}
                }

            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "notifications",
                    tint = Ocean_Blue
                )

                Spacer(Modifier.size(10.dp))

                Text(
                    text = "30% of your expenses, looks good.", style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        color = TextGreen,
                    )
                )
            }
        }

        BackGround(
            modifier = Modifier
                .fillMaxHeight(.7f)
                .fillMaxWidth(), conteudos = listOf {
                Box(
                    Modifier
                        .fillMaxWidth(.8f)
                        .clip(RoundedCornerShape(50.dp))
                        .height(150.dp)
                        .background(Caribbean_Green)
                ) {
                    Row(
                        Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Column(
                            modifier = Modifier.padding(10.dp)
                        ) {

                            CircularProgressWithImage(
                                progress = widthFractionSavingGoals,
                                imageRes = R.drawable.car,
                            )

                            Text(
                                text = "Savings \n on goals",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    lineHeight = 17.95.sp,
                                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                                    color = TextGreen,
                                    textAlign = TextAlign.Center,
                                ),

                                )

                        }

                        VerticalDivider(
                            Modifier
                                .fillMaxHeight(.8f)
                                .background(Light_Green)
                        )

                        Column {
                            Row(
                                Modifier
                                    .padding(10.dp)
                                    .fillMaxWidth(.8f),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.salary),
                                    contentDescription = "Money Icon",
                                )

                                Column(
                                    Modifier.padding(horizontal = 10.dp)
                                ) {
                                    Text(
                                        text = "Revenue Last Week",
                                        style = TextStyle(
                                            fontSize = 12.sp,
                                            fontFamily = FontFamily(Font(R.font.poppins_light)),
                                            color = TextGreen,
                                        )
                                    )

                                    Text(
                                        text = "$4.000.00",
                                        style = TextStyle(
                                            fontSize = 15.sp,
                                            fontFamily = FontFamily(Font(R.font.leaguespartan_bold)),
                                            fontWeight = FontWeight(700),
                                            color = TextGreen,
                                        )
                                    )
                                }

                            }

                            HorizontalDivider(
                                Modifier
                                    .fillMaxWidth(.8f)
                                    .background(Light_Green)
                            )

                            Row(
                                Modifier
                                    .padding(10.dp)
                                    .fillMaxWidth(.8f),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceAround
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.garfo),
                                    contentDescription = "Money Icon",
                                    tint = Ocean_Blue
                                )

                                Column(
                                    Modifier.padding(horizontal = 10.dp)
                                ) {
                                    Text(
                                        text = "Food Last Week",
                                        style = TextStyle(
                                            fontSize = 12.sp,
                                            fontFamily = FontFamily(Font(R.font.poppins_light)),
                                            color = Ocean_Blue,
                                        )
                                    )

                                    Text(
                                        text = "-$100.00",
                                        style = TextStyle(
                                            fontSize = 15.sp,
                                            fontFamily = FontFamily(Font(R.font.leaguespartan_bold)),
                                            fontWeight = FontWeight(700),
                                            color = Ocean_Blue,
                                        )
                                    )
                                }
                            }

                        }

                    }

                }

                Spacer(
                    Modifier.size(20.dp)
                )

                FiltroText(
                    listaOpcoes = listOf("Daily", "Weekly", "Monthly")
                )


               Column {
                   listaItemListHistory.lista.forEach{
                          ItemListHistory(
                            category = it.category,
                            value = it.value,
                            icon = it.icon
                          )
                   }
               }

            })
    }
}


@Preview
@Composable
private fun HomePrev() {
    Home()
}