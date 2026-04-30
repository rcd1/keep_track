package com.example.keepingtrack.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.keepingtrack.ui.theme.AppTypography

@Preview
@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel()) {

    val state by viewModel.uiState.collectAsState()


    Scaffold(
        modifier = Modifier,
        topBar = {
            HomeTopBar(
                currentDate = viewModel.getCurrentDate()
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(Icons.Default.Add, "Add Counter")
            }
        }
    ) { innerPadding -> // Wait this is awesome
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(state.counters) { counter ->
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
        }
    }
}

@Composable
fun HomeTopBar(
    currentDate: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.09f)
            .background(MaterialTheme.colorScheme.primary),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        // Options
        IconButton(
            onClick = {}
        ) {
            Icon(
                Icons.Default.Settings,
                "Options",
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
        // Need to grab current time and format to DD/MM/YYYY
        Text(
            text = currentDate,
            style = AppTypography.headlineMedium,
            fontStyle = FontStyle.Italic,
            color = MaterialTheme.colorScheme.onPrimary
        )
        // Toggle 'Edit Counter' Mode
        IconButton(
            onClick = {} //Should switch
        ) {
            Icon(
                Icons.Default.Edit,
                "Edit Counters",
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
        // Navigate to Metrics Screen
        IconButton(
            onClick = {}
        ) {
            Icon(
                Icons.Default.DateRange,
                "View Metrics",
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
    }

}