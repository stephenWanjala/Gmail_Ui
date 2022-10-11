package com.wantech.gmailui.feature_homeMail.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.wantech.gmailui.feature_homeMail.presentation.util.Screen
import com.wantech.gmailui.feature_meet.presentation.MeetingsScreen

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(Screen.HomeScreen.route) {
            HomeMailScreen(navController)
        }
        composable(Screen.MeetScreen.route) {
            MeetingsScreen()
        }
    }
}