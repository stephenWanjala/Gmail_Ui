package com.wantech.gmailui.feature_homeMail.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
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
            .padding(16.dp)
            .height(40.dp)

            .clip(RoundedCornerShape(20.dp)),
        backgroundColor =if (isSystemInDarkTheme()) Color.DarkGray else Color.LightGray.copy(alpha = 0.9f),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.0.dp)

    ) {

        Icon(imageVector = appBarItem.navIcon, contentDescription = appBarItem.description,
            modifier = Modifier
                .padding(start = 8.dp)
                .clickable { onClickNavigationIcon() })
        Spacer(modifier = Modifier.width(8.dp))


        Text(text = if (meetScreen) "Meet" else appBarItem.searchHint,
            modifier = if (meetScreen) Modifier.weight(1f) else Modifier
                .clickable { onCLickHintText() }
                .weight(1f),
            textAlign = if (meetScreen) TextAlign.Center else null
        )

        Spacer(modifier = Modifier.width(8.dp))

        Icon(
            imageVector = appBarItem.profileIcon, contentDescription = "profile",
            tint = if (isSystemInDarkTheme()) Color.DarkGray else Color(0xFFFAFAE4),
            modifier = Modifier
                .padding(end = 16.dp, top = 0.dp, bottom = 0.dp)
                .clip(CircleShape)
                .clickable { onClickProfileIcon() }
                .background(
                    color = if (isSystemInDarkTheme()) Color.Gray else Color.Gray.copy(
                        alpha = .7f
                    ),
                    shape = CircleShape
                )
        )


    }
}


