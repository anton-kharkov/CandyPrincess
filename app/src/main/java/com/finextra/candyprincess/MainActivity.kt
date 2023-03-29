package com.finextra.candyprincess

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.content.edit

private lateinit var sharedPreferences: SharedPreferences

private var score = 1000
private var bit = 50

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        @Suppress("DEPRECATION")
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        sharedPreferences =
            getSharedPreferences(getString(R.string.score_pref), Context.MODE_PRIVATE)
        score = sharedPreferences.getInt(getString(R.string.score_key), 1000)

        setContent {
            CandyPrincessApp()
        }
    }

    fun getScore(): Int {
        return score
    }

    fun setScore(newScore: Int) {
        score = newScore
    }

    fun setBit(newBit: Int) {
        bit = newBit
    }

    private fun saveScore() {
        if (bit > 100) {
            score += bit - 100
        }

        sharedPreferences.edit {
            putInt(getString(R.string.score_key), score)
        }
    }

    override fun onStop() {
        super.onStop()
        saveScore()
    }
}