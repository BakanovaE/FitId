package com.example.design_system.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FitIdTextButton(text: String, modifier: Modifier = Modifier, onClickAction: () -> Unit = {}) {
    TextButton(
        onClick = onClickAction,
        modifier = modifier
            .padding(16.dp)
            .background(color = MaterialTheme.colorScheme.secondaryContainer, shape = RoundedCornerShape(25))
    ) {
        Text(text = text)
    }
}

@Composable
@Preview
fun FitIdTextButtonPreview() {
    FitIdTextButton(text = "Button")
}
