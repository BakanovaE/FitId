package com.example.design_system.elements

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider

@OptIn(ExperimentalAnimationApi::class, ExperimentalComposeUiApi::class)
@Composable
fun FitIdDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit = {},
    title: String,
    subtitle: String? = null,
    description: String? = null,
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        (LocalView.current.parent as? DialogWindowProvider)?.window?.let { window ->
            window.setDimAmount(0f)
            window.setWindowAnimations(-1)
        }

        Box(
            modifier = modifier,
            contentAlignment = Alignment.Center
        ) {
            var animateIn by remember { mutableStateOf(false) }
            LaunchedEffect(Unit) { animateIn = true }

            AnimatedVisibility(
                visible = animateIn,
                enter = fadeIn(spring(stiffness = Spring.StiffnessHigh)) + scaleIn(
                    initialScale = .8f,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessMediumLow
                    )
                ),
                exit = slideOutVertically { it / 8 } + fadeOut() + scaleOut(targetScale = .95f)
            ) {
                Column(
                    Modifier
                        .pointerInput(Unit) { detectTapGestures { } }
                        .shadow(8.dp, shape = RoundedCornerShape(16.dp))
                        .width(300.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(MaterialTheme.colorScheme.background)
                        .padding(16.dp)
                ) {
                    Text(text = title, modifier = Modifier.padding(2.dp))
                    if (subtitle != null) {
                        Text(text = subtitle, modifier = Modifier.padding(2.dp))
                    }
                    if (description != null) {
                        Text(text = description, modifier = Modifier.padding(2.dp))
                    }
                    FitIdTextButton(
                        text = "Cancel",
                        onClickAction = { onDismissRequest() },
                        modifier = Modifier.align(
                            Alignment.CenterHorizontally
                        )
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun FitIdAlert(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit = {},
    title: String = "Ooops! Something goes wrong",
    description: String? = null,
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        (LocalView.current.parent as? DialogWindowProvider)?.window?.let { window ->
            window.setDimAmount(0f)
            window.setWindowAnimations(-1)
        }

        Box(
            modifier = modifier,
            contentAlignment = Alignment.Center
        ) {
            var animateIn by remember { mutableStateOf(false) }
            LaunchedEffect(Unit) { animateIn = true }

            AnimatedVisibility(
                visible = animateIn,
                enter = fadeIn(spring(stiffness = Spring.StiffnessHigh)) + scaleIn(
                    initialScale = .8f,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessMediumLow
                    )
                ),
                exit = slideOutVertically { it / 8 } + fadeOut() + scaleOut(targetScale = .95f)
            ) {
                Column(
                    Modifier
                        .pointerInput(Unit) { detectTapGestures { } }
                        .shadow(8.dp, shape = RoundedCornerShape(16.dp))
                        .width(300.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(MaterialTheme.colorScheme.background)
                        .padding(16.dp)
                ) {
                    Text(text = title, modifier = Modifier.padding(2.dp))
                    if (description != null) {
                        Text(text = description, modifier = Modifier.padding(2.dp))
                    }
                    FitIdTextButton(
                        text = "ОК",
                        onClickAction = { onDismissRequest() },
                        modifier = Modifier.align(
                            Alignment.CenterHorizontally
                        )
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun DialogPreview() {
    FitIdDialog(
        title = "Title",
        subtitle = "Subtitle",
        description = "Very long description. Very long description. Very long description. Very long description. Very long description. Very long description. "
    )
}