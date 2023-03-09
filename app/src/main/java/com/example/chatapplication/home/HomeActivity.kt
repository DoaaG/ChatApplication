package com.example.chatapplication.home

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.chatapplication.R
import com.example.chatapplication.base.BaseActivity
import com.example.chatapplication.databinding.ActivityHomeBinding
import com.example.chatapplication.newroom.NewRoomActivity


class HomeActivity : BaseActivity<HomeVIewModel,ActivityHomeBinding>(),HomeNavigator {
    lateinit var Adapter: RoomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.homeContent.home = viewModel  // linking with xml
        viewModel.homeNavigator = this

        Adapter = RoomAdapter(listOf())
        binding.homeContent.roomsRecycler.adapter = Adapter

        observeRoomLiveData()


    }
    private fun observeRoomLiveData(){
        viewModel.roomLiveData.observe(this) {
            Adapter.changeData(it)
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadRooms()
    }
    override fun getLayoutActivity(): Int = R.layout.activity_home

    override fun getClassViewModel(): HomeVIewModel =
        ViewModelProvider(this)[HomeVIewModel::class.java]

    override fun createNewRoom() {
        var intent = Intent(this, NewRoomActivity::class.java)
        startActivity(intent)
    }
}