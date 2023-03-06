package com.example.chatapplication.database

import com.example.chatapplication.database.models.User
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore

// getInstance() repeat one constant task so it's singleton

class FireStoreUtils {
    val usersCollectionName = "users"
    fun insertUserToDataBase(user: User) : Task<Void> {
        val docReference = usersCollection().document(user.id!!)
        return docReference.set(user)
    }
    fun getUserFromDataBase(userId: String): Task<DocumentSnapshot> {
        val docReference = usersCollection().document(userId)
        return docReference.get()
    }

    private fun usersCollection():CollectionReference{
        val dataBase = FirebaseFirestore.getInstance()
         return dataBase.collection(usersCollectionName)
    }

}