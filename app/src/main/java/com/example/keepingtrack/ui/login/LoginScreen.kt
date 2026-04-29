package com.example.keepingtrack.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.keepingtrack.ui.theme.AppTypography

@Preview
@Composable
fun LoginScreen() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        topBar = {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.10f)
                    .background(MaterialTheme.colorScheme.primary),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Keeping Track",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = AppTypography.displayMedium,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(vertical = 15.dp)
                    )
                Icon(Icons.Default.Favorite,
                    null,
                    tint = MaterialTheme.colorScheme.onPrimary)
            }
        },
        bottomBar = {}
    ) { innerPadding ->
        LoginFields(innerPadding)
    }
}

@Composable
fun LoginFields(innerPadding: PaddingValues) {
//            Spacer(Modifier.fillMaxHeight(0.3f))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(MaterialTheme.colorScheme.primaryContainer),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Username TextField
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Username", style = MaterialTheme.typography.labelLarge) },
            singleLine = true,
            trailingIcon = {
                IconButton(
                    onClick = {},
                ) {
                    Icon(Icons.Default.Clear, "Clear Username")
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier,
        )
        Spacer(Modifier.height(20.dp))
        // Password TextField
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Password", style = MaterialTheme.typography.labelLarge) },
            singleLine = true,
            trailingIcon = {
                IconButton(
                    onClick = {},
                ) {
                    Icon(Icons.Default.Clear, "Clear Username")
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier,
        )
        Spacer(Modifier.height(30.dp))
        Button(
            onClick = {/*Need to give something the username and password*/ },
            modifier = Modifier
        ) {
            Text("Login")
        }
    }
}