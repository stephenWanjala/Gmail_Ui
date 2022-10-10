package com.wantech.gmailui.feature_homeMail.domain.util

sealed class MailTime() {
    data class SentTime(val time:Long):MailTime()
    data class ReceiveTime(val time:Long):MailTime()
}
