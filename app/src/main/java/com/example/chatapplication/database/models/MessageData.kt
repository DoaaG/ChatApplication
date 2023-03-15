package com.example.chatapplication.database.models
import com.google.firebase.Timestamp
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*

data class MessageData(
    var id: String? = null,
    var message:String? = null,
    var time: Date? = null,
    var senderId: String? = null,
    var senderName: String? = null
): Serializable
{
   fun time(): String {
    return  SimpleDateFormat("MMMM dd,yyyy - hh:mm a", Locale.getDefault()).format(time)
    }
}
//
//FirebaseFirestore.getInstance()
//return dataBase.collection(usersCollectionName)
//FirebaseFirestore.getInstance().collection("messages")

//val timestamp: Timestamp = document.getData().get("createdAt")
//val tsLong = System.currentTimeMillis() / 1000
//val result: Long = tsLong - timestamp.seconds