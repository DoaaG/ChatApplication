package com.example.chatapplication.messages

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.example.chatapplication.UserProvider
import com.example.chatapplication.base.BaseViewModel
import com.example.chatapplication.database.FireStoreUtils
import com.example.chatapplication.database.models.MessageData
import com.example.chatapplication.database.models.RoomData
import com.google.firebase.Timestamp
import com.google.firebase.firestore.ktx.toObject
import java.util.*

class ChatViewModel : BaseViewModel<ChatNavigator>() {
    var chatNavigator: ChatNavigator? = null
    var message = ObservableField<String?>()
    var messagesLiveData = MutableLiveData<MutableList<MessageData>>()
    lateinit var roomPosition: RoomData



    fun back() {
        chatNavigator?.back()
    }

    fun sendMessage() {

        val message = MessageData(
            message = message.get()!!,
            time = Calendar.getInstance().time,
            senderName = UserProvider.user?.firstName + " " + UserProvider.user?.lastName,
            senderId = UserProvider.user?.id.toString(),
            id = " "
        )
        FireStoreUtils().insertMessage(message, roomPosition).addOnSuccessListener {
            Log.e("sendMessageFunction", "message sent")
//            loadMessages()
        }.addOnFailureListener {
            Log.e("sendMessageFunction", "message sent fail")
        }
    }

    fun loadMessages() {
        FireStoreUtils().getMessages(roomPosition).orderBy("time")
            .addSnapshotListener { snapshot, e ->
            if (e != null) {
                Log.e("loadMessage", "Listen failed.", e)
                return@addSnapshotListener
            }

            if (snapshot != null && snapshot.documents.isNotEmpty()) {
                var messagesList: MutableList<MessageData> = mutableListOf()

                snapshot.documents.forEach {
                    messagesList.add(it.toObject()!!)
                }
                messagesLiveData.value = messagesList
                Log.e("loadMessage", "loading logged")
            } else {
                Log.e("loadMessage", "Current data: null")
            }
        }
    }
}

/**
Firebase.firestore.collection("rooms")
.document(roomPosition.id!!)
.collection("messages")
 */
