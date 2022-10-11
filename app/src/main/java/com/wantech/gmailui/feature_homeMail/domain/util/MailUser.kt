package com.wantech.gmailui.feature_homeMail.domain.util

import com.wantech.gmailui.R

sealed class MailUser {
    data class MailSender(
        val senderName: String,
        val senderEmail: String,
        val senderPic: Int? = R.drawable.ic_launcher_background
    ) : MailUser()
    data class MailReceiver(
        val senderName: String,
        val receiverEmail: String,
        val receiverPic: Int? = R.drawable.ic_launcher_background
    ) : MailUser()
}
