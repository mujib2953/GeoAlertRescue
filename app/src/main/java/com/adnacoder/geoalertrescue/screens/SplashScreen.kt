package com.adnacoder.geoalertrescue.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.adnacoder.geoalertrescue.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
) {
    val scale = remember {
        Animatable(0f)
    }

    LaunchedEffect(
        key1 = true
    ) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 1000,
                easing = {
                    OvershootInterpolator(4f)
                        .getInterpolation(it)
                }
            )
        )

        // --- splash screen will be visible to user for 3seconds before it navigate to home screen
        delay(3000L)

        navController.navigate("home_screen")
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.base_image_2_transparent),
            contentDescription = "App Logo",
            modifier = Modifier
                .scale(scale = scale.value)
        )
    }
}
