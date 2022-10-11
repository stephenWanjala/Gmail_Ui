package com.wantech.gmailui.feature_homeMail.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.wantech.gmailui.feature_homeMail.presentation.util.MenuItem
import com.wantech.gmailui.ui.theme.BadgeColor
import com.wantech.gmailui.ui.theme.NavLight
import com.wantech.gmailui.ui.theme.NavNight

@Composable
fun BottomNavigationBar(
    bottomNavItems: List<MenuItem>,
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    onItemClick: (MenuItem) -> Unit
) {

    BottomNavigation(
        modifier = modifier
            .fillMaxWidth(),
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 0.dp
    ) {
        val backStackEntry = navHostController.currentBackStackEntryAsState()
        bottomNavItems.forEach { menuItem ->
            val selected = menuItem.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                alwaysShowLabel = false,
                onClick = { onItemClick(menuItem) },
                selectedContentColor = MaterialTheme.colors.primary,
                unselectedContentColor = MaterialTheme.colors.onSurface,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .background(
                        color = if (selected) {
                            if (isSystemInDarkTheme()) NavNight else NavLight
                        } else Color.Unspecified,
                        shape = RoundedCornerShape(8.dp)
                    ),
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,


                        ) {
                        if (menuItem.badgeCount > 0) {
                            BadgedBox(
                                badge = {
                                    Text(
                                        text = "${if (menuItem.badgeCount > 99) "99+" else menuItem.badgeCount}",
                                        modifier = Modifier.background(
                                            color = BadgeColor.copy(alpha = 0.1f),
                                            shape = RoundedCornerShape(8.dp)
                                        )
                                    )
                                },

                                ) {
                                Icon(
                                    modifier = Modifier.align(Alignment.BottomStart),
                                    imageVector = menuItem.icon,
                                    contentDescription = menuItem.description,
//                                    tint = if(selected) MaterialTheme.colors.primary else MaterialTheme.colors.onSurface
                                )
                            }
                        } else {
                            Icon(
                                imageVector = menuItem.icon,
                                contentDescription = menuItem.description,
//                                tint = if(selected) MaterialTheme.colors.primary else MaterialTheme.colors.onSurface
                            )
                        }

                    }
                },
//                label = { Text(text = menuItem.name) }
            )
        }
    }

}