package com.wantech.gmailui.feature_homeMail.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.wantech.gmailui.feature_homeMail.presentation.util.AppBarItem

@Composable
fun TheTopBar(
    modifier: Modifier,
    appBarItem: AppBarItem,
    onClickNavigationIcon: () -> Unit,
    onCLickHintText: () -> Unit,
    onClickProfileIcon: () -> Unit,
    meetScreen: Boolean
) {

    TopAppBar(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(50)),
        backgroundColor = if (isSystemInDarkTheme()) Color.DarkGray else Color.LightGray.copy(alpha = 0.1f),


        ) {
        IconButton(onClick = { onClickNavigationIcon() }, modifier = Modifier) {
            Icon(imageVector = appBarItem.navIcon, contentDescription = appBarItem.description)
        }

        Text(text = if (meetScreen) "meet" else appBarItem.searchHint,
            modifier = if (meetScreen) Modifier.fillMaxWidth(1f) else Modifier
                .clickable { onCLickHintText() }
                .weight(1f)
        )

        Spacer(modifier = Modifier.width(16.dp))
        IconButton(
            onClick = { onClickProfileIcon() },
            modifier = Modifier
                .width(40.dp)
                .height(40.dp)
                .padding(end = 16.dp)
                .clip(CircleShape)
                .background(
                    color = if (isSystemInDarkTheme()) Color.Gray else Color.LightGray.copy(alpha = 0.2f),
                    shape = CircleShape
                )
        ) {
            Icon(
                imageVector = appBarItem.profileIcon, contentDescription = "profile",
                tint = if (isSystemInDarkTheme()) Color.DarkGray else Color.LightGray.copy(alpha = 0.8f)
            )
        }

    }
}


