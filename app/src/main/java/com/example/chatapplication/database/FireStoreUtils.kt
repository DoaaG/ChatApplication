package com.example.chatapplication.database

import com.example.chatapplication.database.models.User
import com.example.chatapplication.database.models.RoomData
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

// getInstance() repeat one constant task so it's singleton

class FireStoreUtils {
    val usersCollectionName = "users"
    val roomsCollectionName = "rooms"

    fun insertUserToDataBase(user: User) : Task<Void> {
        val docReference = usersCollection().document(user.id!!)
        return docReference.set(user)
    }
    fun getUserFromDataBase(userId: String): Task<DocumentSnapshot> {
        val docReference = usersCollection().document(userId)
        return docReference.get()
    }

    private fun usersCollection():CollectionReference{
//        val db = Firebase.firestore
        val dataBase = FirebaseFirestore.getInstance()
         return dataBase.collection(usersCollectionName)
    }

    private fun roomsCollection():CollectionReference{
        val dataBase = FirebaseFirestore.getInstance()
        return dataBase.collection(roomsCollectionName)
    }

    fun getAllRooms():Task<QuerySnapshot>{
        return roomsCollection().get()
    }

     fun insertRoom(room: RoomData): Task<Void>  {
         val docReference = roomsCollection().document()
         room.id = docReference.id
         return docReference.set(room)
     }

}