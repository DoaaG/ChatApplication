package com.example.chatapplication.login

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chatapplication.R
import com.example.chatapplication.base.BaseActivity
import com.example.chatapplication.databinding.ActivityLogInBinding
import com.example.chatapplication.register.RegisterActivity

class LogInActivity : BaseActivity<LogInViewModel,ActivityLogInBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.dataLogin = viewModel  // linking with xml
        observeViewModel()
        binding.createAccount.setOnClickListener {
//            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
    fun observeViewModel(){
        viewModel.isLoadingLiveData.observe(this){
            if(it){

            }else{

            }
        }

    }
    override fun getLayoutActivity(): Int = R.layout.activity_log_in
    override fun getClassViewModel(): LogInViewModel = ViewModelProvider(this)[LogInViewModel::class.java]
}