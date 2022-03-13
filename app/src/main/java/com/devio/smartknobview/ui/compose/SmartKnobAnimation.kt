package com.devio.smartknobview.ui.compose

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SmartKnowViewAnimation(
    modifier: Modifier = Modifier,
    isPlaying: Boolean = true
) {
    // Allow resume on rotation
    var currentRotation by remember { mutableStateOf(0f) }

    val rotation = remember { Animatable(currentRotation) }

    LaunchedEffect(isPlaying) {
            // Infinite repeatable rotation when is playing
            rotation.animateTo(
                targetValue = 15f,
                animationSpec = repeatable(
                    iterations = 1,
                    animation = tween(10000, easing = LinearEasing),
                    repeatMode = RepeatMode.Restart
                )
            ) {
                currentRotation = value
            }
        rotation.animateTo(
            targetValue = -15f,
            animationSpec = repeatable(
                iterations = 1,
                animation = tween(3000, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            )
        ) {
            currentRotation = value
        }
    }
    SmartKnobView(modifier = modifier.padding(24.dp), rotationDegrees = rotation.value)
}