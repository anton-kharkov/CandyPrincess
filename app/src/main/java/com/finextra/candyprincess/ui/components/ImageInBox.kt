package com.finextra.candyprincess.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun CandyImageInBox(modifier: Modifier, imageId: Int) {
    Box(
        contentAlignment = Alignment.Center, modifier = Modifier
            .height(100.dp)
            .width(100.dp)
            .background(MaterialTheme.colors.surface, RoundedCornerShape(30))
            .border(4.dp, MaterialTheme.colors.secondary, RoundedCornerShape(30))
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = "",
            modifier = modifier
        )
    }
}