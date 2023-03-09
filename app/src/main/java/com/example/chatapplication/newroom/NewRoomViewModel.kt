package com.example.chatapplication.newroom

import androidx.databinding.ObservableField
import com.example.chatapplication.base.BaseViewModel
import com.example.chatapplication.database.FireStoreUtils
import com.example.chatapplication.database.models.RoomData

class NewRoomViewModel : BaseViewModel<NewRoomNavigator>() {
//    val db = Firebase.firestore
    var newRoomNavigator: NewRoomNavigator? = null
    var selectedCategory :String? = null

    var id = ObservableField<String?>()
    var roomName = ObservableField<String?>()
    var description = ObservableField<String?>()
//    var categoryName = ObservableField<String?>()

    fun createNewRoom(){
//        navigator?.showMessage("Loading..")
        val room = RoomData(id = id.get(),roomName = roomName.get(),description=description.get(),categoryName= selectedCategory )
        FireStoreUtils().insertRoom(room).addOnSuccessListener {
//            navigator?.hide()
            newRoomNavigator?.backToHome()
//            navigator?.showMessage("Inserted successfully")
        }.addOnFailureListener {
            navigator?.hide()
            navigator?.showMessage(it.message?:"Try Again")
        }
    }
}