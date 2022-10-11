package com.wantech.gmailui.feature_homeMail.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.VideoFile
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.wantech.gmailui.feature_homeMail.presentation.components.BottomNavigationBar
import com.wantech.gmailui.feature_homeMail.presentation.util.MenuItem
import com.wantech.gmailui.feature_homeMail.presentation.util.Screen
import com.wantech.gmailui.ui.theme.GmailUiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GmailUiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    val scaffoldState = rememberScaffoldState()
//                    val scope = rememberCoroutineScope()

                    Scaffold(
                        scaffoldState = scaffoldState,
                        bottomBar = {
                            BottomNavigationBar(
                                bottomNavItems = listOf(
                                    MenuItem(
                                        id = Screen.HomeScreen.route,
                                        name = Screen.HomeScreen.route,
                                        icon = Icons.Default.Mail,
                                        description = "home screen",
                                        route = Screen.HomeScreen.route,
                                        badgeCount = 200
                                    ),
                                    MenuItem(
                                        id = Screen.MeetScreen.route,
                                        name = Screen.MeetScreen.route,
                                        icon = Icons.Default.VideoFile,
                                        description = "meetings screen",
                                        route = Screen.MeetScreen.route,
                                    )
                                ),
                                navHostController = navController,
                                onItemClick = { menuItem ->
                                    navController.navigate(menuItem.route)
                                }
                            )
                        }
                    ) {
                        NavigationHost(navController = navController)
                        it.calculateBottomPadding()
                    }

                }
            }
        }
    }
}
