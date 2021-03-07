/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.CountDownTimer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.util.Collections.max

class MainViewModel : ViewModel() {
    var isRunning by mutableStateOf<Boolean>(false)
    var timerSeconds by mutableStateOf<Long>(60)
    var secondsUntilFinished by mutableStateOf<Long>(60)

    private lateinit var countDownTimer: CountDownTimer

    fun toggleRunning(isRunning: Boolean) {
        if (isRunning && timerSeconds == 0L) return

        if (isRunning) {
            countDownTimer = createTimer(timerSeconds)
            countDownTimer.start()
        } else {
            countDownTimer.cancel()
            resetTimer()
        }
        this.isRunning = isRunning
    }

    fun addSeconds(seconds: Long) {
        if (!isRunning) {
            val _timerSeconds = max(listOf(timerSeconds + seconds, 0L))
            timerSeconds = _timerSeconds
            resetTimer()
        }
    }

    fun createTimer(timerSeconds: Long): CountDownTimer {
        return object : CountDownTimer(timerSeconds * 1000, 1000) {
            override fun onFinish() {
                this@MainViewModel.isRunning = false
                resetTimer()
            }

            override fun onTick(millis: Long) {
                secondsUntilFinished = millis / 1000 + 1
            }
        }
    }

    fun resetTimer() {
        secondsUntilFinished = timerSeconds
    }
}
