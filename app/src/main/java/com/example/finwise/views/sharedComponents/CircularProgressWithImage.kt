package com.example.finwise.views.sharedComponents

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finwise.ui.theme.Caribbean_Green
import com.example.finwise.ui.theme.Honeydew
import com.example.finwise.ui.theme.Ocean_Blue

@Composable
fun CircularProgressWithImage(
    progress: Float,
    imageRes: Int,
    modifier: Modifier = Modifier
) {
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(durationMillis = 1000)
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(75.dp)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val strokeWidth = 3.dp.toPx()
            val radius = size.minDimension / 2

            drawCircle(
                color = Caribbean_Green,
                radius = radius - strokeWidth / 2
            )

            drawArc(
                color = Honeydew,
                startAngle = -90f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(strokeWidth, cap = StrokeCap.Round)
            )

            // Parte preenchida (progresso azul)
            drawArc(
                color = Ocean_Blue,
                startAngle = -90f,
                sweepAngle = 360 * animatedProgress,
                useCenter = false,
                style = Stroke(strokeWidth, cap = StrokeCap.Round)
            )
        }

        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier.size(60.dp)
        )
    }
}

@Preview
@Composable
private fun CircularProgressWithImagePrev() {
    CircularProgressWithImage(progress = 0.5f, imageRes = 0)
}
