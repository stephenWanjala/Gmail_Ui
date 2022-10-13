package com.wantech.gmailui.feature_homeMail.presentation.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun MailListItem(
    modifier: Modifier = Modifier,
    onclickProfile: () -> Unit,
    onclickStarred: () -> Unit,
    senderName: String,
    subjectOfMail: String,
    bodyOfMail: String,
    time: String,
    mailStarred: Boolean =false

) {

    Row(
        modifier = modifier
            .fillMaxWidth()
//            .background(
//                MaterialTheme.colors.onPrimary.copy(0.1f),
//                shape = RoundedCornerShape(8.dp)
//            )
            .padding(16.dp)
            .clip(RoundedCornerShape(8.dp))
    ) {
        ProfilePicture(onclickProfile)
        Spacer(modifier = Modifier.width(8.dp))
        NameAndTime(
            userName = senderName,
            subjectOfMail = subjectOfMail,
            timeSent = time,
            onclickStarred = onclickStarred,
            mailBody = bodyOfMail,
            mailStarred = mailStarred
        )

    }
}


@Composable
fun ProfilePicture(onclickProfile: () -> Unit) {
    IconButton(
        onClick = { onclickProfile() },
        modifier = Modifier
            .size(50.dp)
            .background(
                color = MaterialTheme.colors.onSurface,
                shape = CircleShape,
            )
            .clickable { onclickProfile() }
            .clip(CircleShape)
    ) {
        Icon(
            imageVector = Icons.Default.Person, contentDescription = null,
            tint = Color.White
        )
    }
}

@Composable
fun NameAndTime(
    userName: String,
    subjectOfMail: String,
    mailBody: String,
    timeSent: String,
    onclickStarred: () -> Unit,
    mailStarred:Boolean
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
//        .clip(RoundedCornerShape(8.dp))
    ) {


        Row(
            modifier =
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = userName,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h6,
                modifier = Modifier
            )
            Text(
                text = timeSent,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
            )
        }
//    Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Column(modifier = Modifier.fillMaxWidth(0.75F)) {
                Text(
                    text = subjectOfMail,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = mailBody,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
            IconButton(onClick = {
                onclickStarred()

            }) {
                Icon(
                    imageVector = if (mailStarred) Icons.Default.Star else Icons.Default.StarOutline,
                    contentDescription = "starred",

                    )
            }
        }
    }

}


