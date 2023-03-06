package com.example.chatapplication.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.chatapplication.R
import com.example.chatapplication.databinding.ActivityHomeBinding
import com.example.chatapplication.newroom.NewRoomActivity
import com.example.chatapplication.register.RegisterActivity


class HomeActivity : AppCompatActivity() {
    lateinit var roomBinding: ActivityHomeBinding
    lateinit var Adapter: RoomAdapter
    lateinit var list: MutableList<RoomData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        roomBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        createlist()
        Adapter = RoomAdapter(list)
        roomBinding.homeContent.roomsRecycler.adapter = Adapter
        onAddNewRoomClick()

    }

    private fun onAddNewRoomClick() {
        roomBinding.homeContent.addNewRoomFab.setOnClickListener {
            var intent = Intent(this, NewRoomActivity::class.java)
            startActivity(intent)
        }
    }

    fun createlist() {
        list = mutableListOf()
        for (i in 0..10) {
            list.add(RoomData("category"))
        }
    }
}