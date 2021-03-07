package com.example.androiddevchallenge

import android.os.CountDownTimer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.Collections.max

class MainViewModel : ViewModel() {
    var isRunning by mutableStateOf<Boolean>(false)
    var timerSeconds by mutableStateOf<Long>(60)

    private val _secondsUntilFinished = MutableStateFlow<Long>(-1)
    val secondsUntilFinished: StateFlow<Long> = _secondsUntilFinished

    private var countDownTimer = createTimer(0)

    fun toggleRunning(isRunning: Boolean) {
        if (isRunning && timerSeconds == 0L) return

        if (isRunning) {
            countDownTimer = createTimer(timerSeconds)
            countDownTimer.start()
        } else {
            countDownTimer.cancel()
        }
        this.isRunning = isRunning
    }

    fun addSeconds(seconds: Long) {
        if (!isRunning) {
            timerSeconds = max(listOf(timerSeconds + seconds, 0))
        }
    }


    fun createTimer(timerSeconds: Long): CountDownTimer {
        return object : CountDownTimer(timerSeconds * 1000, 1000) {
            override fun onFinish() {
                this@MainViewModel.isRunning = false
                _secondsUntilFinished.value = timerSeconds
            }

            override fun onTick(millis: Long) {
                _secondsUntilFinished.value = millis / 1000 + 1
            }
        }
    }

    fun resetTimer() {

    }
}