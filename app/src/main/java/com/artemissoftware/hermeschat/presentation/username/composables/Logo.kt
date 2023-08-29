package com.artemissoftware.hermeschat.presentation.username.composables

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.InfiniteTransition
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.hermeschat.ui.theme.GrayFade
import com.artemissoftware.hermeschat.ui.theme.HermesChatTheme

@Composable
fun Logo(
    infiniteTransition: InfiniteTransition,
    modifier: Modifier = Modifier,
) {
    val arcColor = MaterialTheme.colorScheme.secondary

    val arcAngle1 by infiniteTransition.animateFloat(
        initialValue = 0F,
        targetValue = 180F,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart,
        ),
        label = "",
    )

    val arcAngle2 by infiniteTransition.animateFloat(
        initialValue = 180F,
        targetValue = 360F,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart,
        ),
        label = "",
    )

    val circleAnimation by infiniteTransition.animateFloat(
        initialValue = 50f,
        targetValue = 72f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, delayMillis = 100, easing = FastOutLinearInEasing),
            repeatMode = RepeatMode.Reverse,
        ),
        label = "",
    )

    Canvas(
        modifier = modifier,
    ) {
        drawArc(
            color = arcColor,
            startAngle = arcAngle1,
            sweepAngle = 90f,
            useCenter = false,
            style = Stroke(width = 10f, cap = StrokeCap.Round),
        )

        drawArc(
            color = arcColor,
            startAngle = arcAngle2,
            sweepAngle = 90f,
            useCenter = false,
            style = Stroke(width = 10f, cap = StrokeCap.Round),
        )

        drawCircle(
            color = GrayFade,
            radius = 96f,
        )

        drawCircle(
            color = arcColor,
            radius = circleAnimation,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ArcRotationAnimationPreview() {
    HermesChatTheme {
        Logo(
            infiniteTransition = rememberInfiniteTransition(label = ""),
            modifier = Modifier
                .padding(12.dp)
                .size(100.dp),
        )
    }
}
