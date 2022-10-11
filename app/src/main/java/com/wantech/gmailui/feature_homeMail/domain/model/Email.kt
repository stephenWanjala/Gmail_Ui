package com.wantech.gmailui.feature_homeMail.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.wantech.gmailui.feature_homeMail.domain.util.MailTime
import com.wantech.gmailui.feature_homeMail.domain.util.MailUserGroup

@Entity
data class Email(
    @PrimaryKey(autoGenerate = true) val mailId: Int,
    val address: MailUserGroup,
    val mailSubject: String,
    val mailBody: String,
    val timeOfMail: MailTime,
    val isStarred: Boolean = false

)
