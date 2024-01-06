package com.example.welcome_impl.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.utils.Constants
import com.example.design_system.elements.FitIdTextButton

@Composable
fun StartPage(modifier: Modifier = Modifier, onButtonClick: (String) -> Unit = {}) {

    Column(modifier = modifier) {

        Text(
            text = "Let's find some exercises by muscles group or equipment. \nMake your choice",
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Start)
        )

        FitIdTextButton(
            text = "Muscles group",
            onClickAction = { onButtonClick(Constants.SEARCH_TYPE_MUSCLES) }
        )

        FitIdTextButton(
            text = "Equipment",
            onClickAction = { onButtonClick(Constants.SEARCH_TYPE_EQUIPMENT) }
        )
    }
}

@Composable
@Preview
fun StartPagePreview() {
    StartPage()
}
