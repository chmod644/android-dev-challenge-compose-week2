package com.example.androiddevchallenge.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Timer(totalSeconds: Long) {
    var s = totalSeconds % 60
    var m = totalSeconds % (60 * 60) / 60
    var h = totalSeconds / (60 * 60)
    var untilFinished = when {
        h > 0 -> {
            "%02d:%02d:%02d".format(h, m, s)
        }
        m > 0 -> {
            "%02d:%02d".format(m, s)
        }
        else -> {
            "%02d".format(s)
        }
    }
    Text(
        untilFinished,
        style = MaterialTheme.typography.h4
    )
}

@Preview("Timer", widthDp = 360, heightDp = 640)
@Composable
fun TimerPreview() {
    Timer(3661)
}