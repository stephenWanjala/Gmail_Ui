package com.wantech.gmailui.feature_homeMail.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BadgedBox
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wantech.gmailui.feature_homeMail.presentation.util.MenuItem

@Composable
fun NavigationDrawer(
    modifier: Modifier,
    drawerMenuItems: List<MenuItem>,
    onNavigationDrawerItemClick: (MenuItem) -> Unit,
    defTextStyle: TextStyle = TextStyle(fontSize = 18.sp)
) {
    LazyColumn(
        modifier = modifier,

        ) {
        items(items = drawerMenuItems) { drawerMenuItem ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onNavigationDrawerItemClick(drawerMenuItem) }
                    .padding(16.dp),
//                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextButton(
                    onClick = { onNavigationDrawerItemClick(drawerMenuItem) },
                ) {
                    Icon(
                        imageVector = drawerMenuItem.icon,
                        contentDescription = drawerMenuItem.description
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = drawerMenuItem.name,
                        style = defTextStyle,
                        modifier = Modifier.weight(1f)
                    )
                }

                if (drawerMenuItem.badgeCount > 0) {
//                    BadgedBox(
//                        badge = {
//                            Text(text = "${if (drawerMenuItem.badgeCount > 99) "99+" else drawerMenuItem.badgeCount}")
//                        }) {
//
//                    }
                    Text(text = "${if (drawerMenuItem.badgeCount > 99) "99+" else drawerMenuItem.badgeCount}")
                }
            }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(.5.dp)
                    .padding(0.dp)
                    .background(Color.White.copy(alpha = .4f))
            )
        }
    }


}