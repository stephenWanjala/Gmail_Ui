package com.wantech.gmailui.feature_homeMail.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VideoFile
import androidx.compose.material.icons.rounded.*
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.wantech.gmailui.feature_homeMail.presentation.components.BottomNavigationBar
import com.wantech.gmailui.feature_homeMail.presentation.components.TheTopBar
import com.wantech.gmailui.feature_homeMail.presentation.util.AppBarItem
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
                    color = MaterialTheme.colors.background.copy(alpha = .1f)
                ) {
                    val navController = rememberNavController()

                    val scaffoldState = rememberScaffoldState()
//                    val scope = rememberCoroutineScope()
                    var isMeet by remember(key1 = navController.currentDestination) {
                        mutableStateOf(navController.currentDestination?.route == Screen.MeetScreen.route)
                    }

                    Scaffold(
                        scaffoldState = scaffoldState,
                        topBar = {

                            TheTopBar(
                                modifier = Modifier.fillMaxWidth(),
                                appBarItem = AppBarItem(
                                    description = "nav icon"
                                ),
                                onClickNavigationIcon = { /*TODO*/ },
                                onCLickHintText = { /*TODO*/ },
                                onClickProfileIcon = {},
                                meetScreen = isMeet
                            )


                        },
                        bottomBar = {
                            BottomNavigationBar(
                                bottomNavItems = listOf(
                                    MenuItem(
                                        id = Screen.HomeScreen.route,
                                        name = Screen.HomeScreen.route,
                                        icon = Icons.Rounded.Mail,
                                        description = "home screen",
                                        route = Screen.HomeScreen.route,
                                        badgeCount = 200
                                    ),
                                    MenuItem(
                                        id = Screen.MeetScreen.route,
                                        name = Screen.MeetScreen.route,
                                        icon = Icons.Rounded.VideoLabel,
                                        description = "meetings screen",
                                        route = Screen.MeetScreen.route,
                                    )
                                ),
                                navHostController = navController,
                                onItemClick = { menuItem ->
                                    navController.navigate(menuItem.route) {
                                        isMeet = menuItem.route == Screen.MeetScreen.route
                                        this.popUpTo(Screen.MeetScreen.route) {
                                            inclusive = true
                                        }

                                    }
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

