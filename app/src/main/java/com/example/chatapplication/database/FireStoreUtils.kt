package com.example.chatapplication.database

import com.example.chatapplication.database.models.MessageData
import com.example.chatapplication.database.models.User
import com.example.chatapplication.database.models.RoomData
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.*

// getInstance() repeat one constant task so it's singleton

class FireStoreUtils {
    private val usersCollectionName = "users"
    private val roomsCollectionName = "rooms"
    private val messagesCollectionName = "messages"


    private fun usersCollection():CollectionReference{
//        val db = Firebase.firestore
        val dataBase = FirebaseFirestore.getInstance()
         return dataBase.collection(usersCollectionName)
    }

    private fun roomsCollection():CollectionReference{
        val dataBase = FirebaseFirestore.getInstance()
        return dataBase.collection(roomsCollectionName)
    }


    fun insertUserToDataBase(user: User) : Task<Void> {
        val docReference = usersCollection().document(user.id!!)
        return docReference.set(user)
    }

    fun insertRoom(room: RoomData): Task<Void>  {
        val docReference = roomsCollection().document()
        room.id = docReference.id
        return docReference.set(room)
    }

    fun insertMessage(message :MessageData , roomPosition :RoomData):Task<Void>{
        val docReference = roomsCollection().document(roomPosition.id.toString())
            .collection(messagesCollectionName).document()
        message.id = docReference.id
        return docReference.set(message)
    }

    fun getMessages(roomPosition: RoomData): CollectionReference {
        val docReference =  roomsCollection().document(roomPosition.id.toString())
            .collection(messagesCollectionName)
        return docReference
    }


    fun getUserFromDataBase(userId: String): Task<DocumentSnapshot> {
        val docReference = usersCollection().document(userId)
        return docReference.get()
    }

    fun getAllRooms():Task<QuerySnapshot>{
        return roomsCollection().get()
    }

}

