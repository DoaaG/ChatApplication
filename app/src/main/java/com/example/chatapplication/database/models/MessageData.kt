package com.example.chatapplication.database.models
import java.io.Serializable
import java.util.Date

data class MessageData(
    var id: String? = null,
    var message:String? = null,
    var time: Date? = null,
    var senderId: String? = null,
    var senderName: String? = null
): Serializable
//{
//    fun setTime(): Date{
//            return time!!
//    }
//}