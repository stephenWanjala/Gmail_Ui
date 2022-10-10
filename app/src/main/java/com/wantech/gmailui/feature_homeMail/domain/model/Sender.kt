package com.wantech.gmailui.feature_homeMail.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Sender(
    val senderName:String,
    @PrimaryKey(autoGenerate = false) val senderEmailAddress:String,
    val profilePicture:Int?
) {

}