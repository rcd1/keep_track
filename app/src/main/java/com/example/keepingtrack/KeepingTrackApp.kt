package com.example.keepingtrack
// Ryan typed a thing or two here.
// April 14th, 2026
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.keepingtrack.ui.screens.HomeScreen
import com.example.keepingtrack.ui.screens.LoginScreen

/**
 * Small enum For screen names the app can navigate.
 * @param title String Resource ID, will be used for Routes.
 */
enum class AppScreen(@StringRes val title:Int) {
    Login(R.string.login),
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
        startDestination = AppScreen.Login.name,
    ) {
        composable(AppScreen.Login.name) {
            LoginScreen()
        }
        composable(AppScreen.Home.name) {
            HomeScreen()
        }
        composable(AppScreen.AddCounter.name) {

        }
    }
}