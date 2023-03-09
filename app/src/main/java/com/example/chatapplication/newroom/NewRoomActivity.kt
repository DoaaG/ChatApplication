package com.example.chatapplication.newroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.chatapplication.R
import com.example.chatapplication.base.BaseActivity
import com.example.chatapplication.databinding.ActivityLogInBinding
import com.example.chatapplication.databinding.ActivityNewRoomBinding
import com.example.chatapplication.home.HomeActivity

class NewRoomActivity : BaseActivity<NewRoomViewModel, ActivityNewRoomBinding>(),NewRoomNavigator {
//    lateinit var binding: ActivityNewRoomBinding
//    lateinit var viewModel: NewRoomViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_new_room)
//        viewModel = ViewModelProvider(this)[NewRoomViewModel::class.java]
        binding.newRoom = viewModel
        viewModel.newRoomNavigator = this
        spinnerListener()
    }

    private fun spinnerListener() {
        binding.categorySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, itemView: View?, position: Int, p3: Long) {
                val selectedCategory =  parent?.getItemAtPosition(position).toString()
                viewModel.selectedCategory = selectedCategory
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
    }


    override fun backToHome() {
       finish()
    }

    override fun getLayoutActivity(): Int =  R.layout.activity_new_room

    override fun getClassViewModel(): NewRoomViewModel = ViewModelProvider(this)[NewRoomViewModel::class.java]


}