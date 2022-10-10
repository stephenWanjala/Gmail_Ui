package com.wantech.gmailui.feature_homeMail.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Receiver(
    val receiverName: String,
    @PrimaryKey(autoGenerate = false) val  receiverEmailAddress:String,
    val receiverProfilePicture: Int?
) {
}