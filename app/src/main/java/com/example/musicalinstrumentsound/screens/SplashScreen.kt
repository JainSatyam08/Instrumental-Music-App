package com.example.musicalinstrumentsound.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.musicalinstrumentsound.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(onAnimationFinished: () -> Unit) {
    val scale = remember { Animatable(0f) }
    val rotation = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.3f,
            animationSpec = tween(durationMillis = 500)
        )

        launch {
            rotation.animateTo(
                targetValue = 1080f,
                animationSpec = tween(1200)
            )
        }
        scale.animateTo(
            targetValue = 2f,
            animationSpec = tween(durationMillis = 500)
        )

        delay(400L)
        onAnimationFinished()
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Image(
            painter = painterResource(id = R.drawable.music_splash),
            contentDescription = "Logo",
            modifier = Modifier
                .scale(scale.value)
                .size(150.dp)
                .clip(CircleShape)
                .rotate(rotation.value),
            contentScale = ContentScale.Crop
        )
    }
}