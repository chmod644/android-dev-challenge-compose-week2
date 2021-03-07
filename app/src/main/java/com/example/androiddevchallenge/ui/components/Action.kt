package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun Action(isRunning: Boolean) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text("+1min")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { /*TODO*/ }) {
                Text("+10sec")
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            var icon = if (isRunning) Icons.Default.Pause else Icons.Default.PlayArrow
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(icon, "Resume")
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text("-1min")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { /*TODO*/ }) {
                Text("-10sec")
            }
        }
    }
}

@Preview("Action under Running", widthDp = 360, heightDp = 640)
@Composable
fun ActionUnderRunningPreview() {
    MyTheme {
        Surface(
            color = MaterialTheme.colors.surface,
            modifier = Modifier.fillMaxWidth()
        ) {
            Action(true)
        }
    }
}

@Preview("Action not Running", widthDp = 360, heightDp = 640)
@Composable
fun ActionNotRunningPreview() {
    MyTheme {
        Surface(color = MaterialTheme.colors.surface) {
            Action(false)
        }
    }
}
