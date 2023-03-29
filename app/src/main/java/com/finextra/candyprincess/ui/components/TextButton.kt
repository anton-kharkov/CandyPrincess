package com.finextra.candyprincess.ui.components

import androidx.compose.ui.graphics.Shape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun CandyPrincessTextButton(
    onClick: () -> Unit,
    enabled: Boolean = true,
    modifier: Modifier,
    shape: Shape,
    textId: Int
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier,
        shape = shape,
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary)
    ) {
        Text(
            text = stringResource(id = textId),
            fontSize = 21.sp,
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}