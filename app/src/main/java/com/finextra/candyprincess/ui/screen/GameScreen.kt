package com.finextra.candyprincess.ui.screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.finextra.candyprincess.MainActivity
import com.finextra.candyprincess.R
import com.finextra.candyprincess.ui.components.CandyImageButton
import com.finextra.candyprincess.ui.components.CandyImageInBox
import com.finextra.candyprincess.ui.components.CandyPrincessTextButton
import com.finextra.candyprincess.ui.components.InfoBoard
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
@Composable
fun GameScreen() {
    val imageList = arrayListOf(
        R.drawable.candy_colorful,
        R.drawable.candy_blue,
        R.drawable.candy_orange,
        R.drawable.candy_pink,
        R.drawable.candy_red,
    )

    val randomImageList by remember {
        mutableStateOf(
            intArrayOf(
                R.drawable.candy_colorful,
                R.drawable.candy_colorful,
                R.drawable.candy_colorful
            )
        )
    }

    val activity = (LocalContext.current as MainActivity)

    var startAnimation by remember { mutableStateOf(false) }

    val animatedScale by animateFloatAsState(
        targetValue = if (startAnimation) 0f else 1f,
        animationSpec = tween(durationMillis = 500)
    )

    val imageModifier = Modifier
        .height(80.dp)
        .width(80.dp)
        .graphicsLayer(scaleX = animatedScale, scaleY = animatedScale)

    var mutableScore by remember { mutableStateOf(activity.getScore()) }
    var mutableBit by remember { mutableStateOf(50) }
    var mutableWin by remember { mutableStateOf("0") }
    var spinStart by remember { mutableStateOf(true) }
    var index: Int
    var win: Int

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.surface
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp)
            ) {
                InfoBoard(
                    mainText = stringResource(id = R.string.score),
                    textInfo = mutableScore.toString()
                )
                InfoBoard(
                    mainText = stringResource(id = R.string.last_result),
                    textInfo = mutableWin
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .background(MaterialTheme.colors.primary, RoundedCornerShape(20))
                        .border(6.dp, MaterialTheme.colors.secondary, RoundedCornerShape(20))
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        CandyImageInBox(imageModifier, randomImageList[0])
                        Spacer(modifier = Modifier.width(15.dp))
                        CandyImageInBox(imageModifier, randomImageList[1])
                        Spacer(modifier = Modifier.width(15.dp))
                        CandyImageInBox(imageModifier, randomImageList[2])
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .border(2.dp, MaterialTheme.colors.primary, RoundedCornerShape(20))
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                CandyImageButton(onClick = {
                    if (mutableBit > 50) {
                        mutableBit -= 50
                        mutableScore += 50
                        activity.setBit(mutableBit)
                        activity.setScore(mutableScore)
                    }
                }, spinStart, imageId = R.drawable.ic_minus)
                Spacer(modifier = Modifier.width(20.dp))
                InfoBoard(
                    mainText = stringResource(id = R.string.bit),
                    textInfo = mutableBit.toString()
                )
                Spacer(modifier = Modifier.width(20.dp))
                CandyImageButton(onClick = {
                    if (mutableScore >= 50) {
                        mutableBit += 50
                        mutableScore -= 50
                        activity.setBit(mutableBit)
                        activity.setScore(mutableScore)
                    }
                }, spinStart, imageId = R.drawable.ic_plus)
            }

            CandyPrincessTextButton(
                onClick = {
                    spinStart = false

                    GlobalScope.launch {
                        repeat(4) {
                            index = 0
                            startAnimation = true
                            delay(500)

                            do {
                                randomImageList[index] = imageList.random()
                                index++
                            } while (index != 3)

                            startAnimation = false
                            delay(500)
                        }

                        spinStart = true

                        win = if (
                            randomImageList[0] == randomImageList[1] &&
                            randomImageList[1] == randomImageList[2]
                        ) {
                            mutableBit * 5
                        } else if (
                            randomImageList[0] == randomImageList[1] ||
                            randomImageList[1] == randomImageList[2]
                        ) {
                            mutableBit * 2
                        } else {
                            0
                        }

                        if (win != 0) {
                            mutableScore += win
                            mutableWin = "+ $win"
                            activity.setScore(mutableScore)
                        } else {
                            if (mutableScore - mutableBit <= 0) {
                                if (mutableScore == 0) {
                                    mutableBit = 50
                                } else {
                                    mutableScore = 0
                                }
                            } else {
                                mutableScore -= mutableBit
                            }
                            mutableWin = "- $mutableBit"

                            activity.setBit(mutableBit)
                            activity.setScore(mutableScore)
                        }
                    }
                },
                enabled = spinStart,
                modifier = Modifier
                    .width(90.dp)
                    .height(90.dp),
                shape = RoundedCornerShape(50.dp), textId = R.string.spin
            )
        }
    }
}