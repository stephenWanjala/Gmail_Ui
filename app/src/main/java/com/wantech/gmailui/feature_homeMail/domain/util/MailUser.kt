package com.wantech.gmailui.feature_homeMail.domain.util

sealed class MailUser {
    data class MailSender(
        val senderName: String,
        val senderEmail: String,
        val senderPic: Int? = null
    ) : MailUser()
    data class MailReceiver(
        val senderName: String,
        val receiverEmail: String,
        val receiverPic: Int? = null
    ) : MailUser()
}
