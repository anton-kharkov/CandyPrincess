package com.finextra.candyprincess.ui.screen

import android.app.Activity
import com.finextra.candyprincess.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.finextra.candyprincess.ui.components.CandyPrincessTextButton

@Composable
fun HomeScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.surface
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val activity = (LocalContext.current as Activity)

            val modifier = Modifier
                .width(150.dp)
                .height(80.dp)

            CandyPrincessTextButton(
                onClick = { navController.navigate("game") },
                modifier = modifier,
                shape = RoundedCornerShape(35.dp),
                textId = R.string.play
            )

            Spacer(modifier = modifier.height(20.dp))

            CandyPrincessTextButton(
                onClick = { navController.navigate("private_policy") },
                modifier = modifier,
                shape = RoundedCornerShape(35.dp),
                textId = R.string.private_policy
            )

            Spacer(modifier = modifier.height(20.dp))

            CandyPrincessTextButton(
                onClick = { activity.finish() },
                modifier = modifier,
                shape = RoundedCornerShape(35.dp),
                textId = R.string.exit
            )
        }
    }
}