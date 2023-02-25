package com.example.chatapplication.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.chatapplication.R
import com.example.chatapplication.databinding.ActivityLogInBinding
import com.example.chatapplication.register.RegisterActivity

class LogInActivity : AppCompatActivity() {
    private lateinit var logInBinding :ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logInBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_log_in)   //dataBinding

        logInBinding.createAccount.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}