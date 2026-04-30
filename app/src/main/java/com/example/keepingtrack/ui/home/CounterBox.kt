package com.example.keepingtrack.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.keepingtrack.data.Counter

@Composable
fun CounterBox(counter: Counter, viewModel: HomeViewModel) {
    val textState = rememberSaveable { mutableStateOf(counter.count.toString()) }
    // Liked my TextField, but the buttons weren't playing nicely.
    LaunchedEffect(counter.count) {
        textState.value = counter.count.toString()
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = counter.name,
            modifier = Modifier.weight(.7f)
        )
        IconButton(
            modifier = Modifier.weight(.1f),
            onClick = {
                viewModel.decrement(counter)
            }
        ) {
            Icon(Icons.Filled.KeyboardArrowDown, "")
        }
        // We can go up and down by 1, but what if we did it faster?
        TextField(
            value = textState.value,
            onValueChange = {
                textState.value = it
            },
            // You make me angry TextStyle
            textStyle = LocalTextStyle.current.copy(
                textAlign = TextAlign.Center
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    val number = textState.value.toIntOrNull()
                    if (number != null) {
                        viewModel.updateCount(counter, number)
                    } else {
                        textState.value = counter.count.toString()
                    }
                }
            ),
            modifier = Modifier
                .weight(.15f)
                // JIC you tap on another counter, it'll update :)
                .onFocusChanged {
                    if (!it.isFocused) {
                        val number = textState.value.toIntOrNull()
                        if (number != null && number >= 0) {
                            viewModel.updateCount(counter, number)
                        } else {
                            textState.value = counter.count.toString()
                        }
                    }
                }
        )
        IconButton(
            modifier = Modifier.weight(.1f),
            onClick = {
                viewModel.increment(counter)
            }
        ) {
            Icon(Icons.Filled.KeyboardArrowUp, "")
        }
    }
}