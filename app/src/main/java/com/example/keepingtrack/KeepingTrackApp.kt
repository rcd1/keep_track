package com.example.keepingtrack
// Ryan typed a thing or two here.
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.keepingtrack.ui.home.HomeScreen

/**
 * Small enum For screen names the app can navigate.
 * @param title String Resource ID, will be used for Routes.
 */
enum class AppScreen(@StringRes val title: Int) {
    Home(R.string.home),
    AddCounter(R.string.add_counter),
}

/**
 * The Thingy~
 */
@Composable
fun KeepingTrackApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreen.Home.name,
    ) {
        composable(AppScreen.Home.name) {
            HomeScreen()
        }
        composable(AppScreen.AddCounter.name) {

        }
    }
}