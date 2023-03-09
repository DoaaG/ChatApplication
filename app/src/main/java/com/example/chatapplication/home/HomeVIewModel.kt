package com.example.chatapplication.home

import androidx.lifecycle.MutableLiveData
import com.example.chatapplication.base.BaseViewModel
import com.example.chatapplication.database.FireStoreUtils
import com.example.chatapplication.database.models.RoomData

class HomeVIewModel : BaseViewModel<HomeNavigator>(){
     var roomLiveData = MutableLiveData<List<RoomData>>()
     var homeNavigator :HomeNavigator? = null

     fun navToCreateNewRoom(){
          homeNavigator?.createNewRoom()
     }

     fun loadRooms() {
          FireStoreUtils().getAllRooms()
               .addOnCompleteListener {
                    if (!it.isSuccessful) {
                         navigator?.showMessage("${it.exception?.message}")
                    }
                  val rooms =  it.result.toObjects(RoomData::class.java)
                    roomLiveData.value = rooms
               }
     }

}