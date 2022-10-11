package com.wantech.gmailui.feature_homeMail.presentation.util

import androidx.compose.ui.graphics.vector.ImageVector

data class MenuItem(
    val id: String,
    val name: String,
    val icon: ImageVector,
    val route: String,
    val description: String,
    val badgeCount: Int = 0
)
