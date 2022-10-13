package com.wantech.gmailui.feature_homeMail.presentation.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

data class AppBarItem(
    val navIcon:ImageVector =Icons.Default.Menu,
    val searchHint:String ="Search in Mail",
    val profileIcon:ImageVector = Icons.Default.Person,
    val description:String
)
