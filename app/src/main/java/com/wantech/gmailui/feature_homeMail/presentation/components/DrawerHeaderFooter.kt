package com.wantech.gmailui.feature_homeMail.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.wantech.gmailui.feature_homeMail.presentation.util.MenuItem

@Composable
fun DrawerHeader(
    text: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp),
//        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.TopStart)
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .align(Alignment.BottomStart)
                .background(Color.White.copy(alpha = .4f))
        )
    }
}


@Composable
fun DrawerFooter(
    footerItems: List<MenuItem>,
) {
    Spacer(modifier = Modifier.height(16.dp))
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(footerItems) { menuItem ->
            Row {
                Icon(imageVector = menuItem.icon, contentDescription = menuItem.description)
                Spacer(modifier = Modifier.width(16.dp))

                Text(text = menuItem.name)
            }

            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}