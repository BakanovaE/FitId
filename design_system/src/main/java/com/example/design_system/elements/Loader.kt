package com.example.design_system.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun FitIdLoader(modifier: Modifier = Modifier) {

    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.Asset("fitness-animation.json")
    )

    Column {

        LottieAnimation(
            modifier = modifier.size(size = 240.dp).align(Alignment.CenterHorizontally),
            composition = composition
        )

        Spacer(modifier = Modifier.height(height = 12.dp))

        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Loading",
            fontSize = 28.sp
        )
    }
}