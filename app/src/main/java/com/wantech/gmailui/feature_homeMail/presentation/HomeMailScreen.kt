package com.wantech.gmailui.feature_homeMail.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.wantech.gmailui.feature_homeMail.presentation.components.MailListItem
import java.time.LocalDateTime.now

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeMailScreen(navController: NavHostController) {
var isMailStarred  by remember {
    mutableStateOf( false)
}

    LazyColumn(
        modifier = Modifier
            .padding(bottom = 64.dp)
            .fillMaxWidth()
    ) {
        item {
            MailListItem(
                onclickProfile = { /*TODO*/ },
                onclickStarred = { isMailStarred =!isMailStarred },
                senderName = "Mail userName$",
                subjectOfMail = "This is the subject of this email r just not much imp",
                bodyOfMail = "The body the email ,just a test body nothing much here see",
                time = "${now().hour} :${kotlin.math.abs(now().minute)} ${if (now().hour >= 12) "Pm" else "Am"}",
                mailStarred = isMailStarred
            )
        }
    }
}