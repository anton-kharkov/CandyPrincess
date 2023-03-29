package com.finextra.candyprincess.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InfoBoard(mainText: String, textInfo: String) {
    Box(
        modifier = Modifier
            .width(120.dp)
            .height(60.dp)
    ) {
        Box(
            modifier = Modifier
                .width(120.dp)
                .height(60.dp)
                .background(MaterialTheme.colors.primary, RoundedCornerShape(30))
        )
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier
                .width(120.dp)
                .height(30.dp)
                .background(MaterialTheme.colors.primary, RoundedCornerShape(50))
                .border(3.dp, MaterialTheme.colors.secondary, RoundedCornerShape(50))
        ) {
            Text(text = mainText, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier
                .width(120.dp)
                .height(60.dp)
                .border(1.dp, MaterialTheme.colors.primary, RoundedCornerShape(30))
        ) {
            Text(text = textInfo, fontSize = 18.sp)
        }
    }
}

@Preview
@Composable
fun PreviewInfoBoard() {
    InfoBoard(mainText = "Score", textInfo = "1000")
}