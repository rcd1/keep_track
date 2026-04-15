package com.example.keepingtrack.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.keepingtrack.ui.theme.AppTypography
@Preview
@Composable
fun HomeScreen() {
    Scaffold(
        modifier = Modifier,
        topBar = {HomeTopBar()},
        bottomBar = {

        }
    ) {

    }
}

@Composable
fun HomeTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.07f)
            .background(MaterialTheme.colorScheme.primary),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        IconButton(
            onClick = {}
        ) {
            Icon(Icons.Default.Settings,
                "Options",
                tint = MaterialTheme.colorScheme.onPrimary)
        }
        Text("4/15/2026",
            style = AppTypography.headlineMedium,
            fontStyle = FontStyle.Italic,
            color = MaterialTheme.colorScheme.onPrimary
        )
        IconButton(
            onClick = {}
        ) {
            Icon(Icons.Default.Edit,
                "Edit Counters",
                tint = MaterialTheme.colorScheme.onPrimary)
        }
        IconButton(
            onClick = {}
        ) {
            Icon(Icons.Default.DateRange,
                "View Metrics",
                tint = MaterialTheme.colorScheme.onPrimary)
        }
    }

}