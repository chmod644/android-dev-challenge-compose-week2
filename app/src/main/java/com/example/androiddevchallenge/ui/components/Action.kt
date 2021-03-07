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
fun Action(isRunning: Boolean, onChangeRunning: (Boolean) -> Unit, onAddSeconds: (Long) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        if (!isRunning) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Button(onClick = { onAddSeconds(60) }) {
                    Text("+1min")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { onAddSeconds(10) }) {
                    Text("+10sec")
                }
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            var icon = if (isRunning) Icons.Default.Pause else Icons.Default.PlayArrow
            FloatingActionButton(onClick = { onChangeRunning(!isRunning) }) {
                Icon(icon, "Resume")
            }
        }
        if (!isRunning) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Button(onClick = { onAddSeconds(-60) }) {
                    Text("-1min")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { onAddSeconds(-10) }) {
                    Text("-10sec")
                }
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
            Action(true, {}, {})
        }
    }
}

@Preview("Action not Running", widthDp = 360, heightDp = 640)
@Composable
fun ActionNotRunningPreview() {
    MyTheme {
        Surface(color = MaterialTheme.colors.surface) {
            Action(false, {}, {})
        }
    }
}
