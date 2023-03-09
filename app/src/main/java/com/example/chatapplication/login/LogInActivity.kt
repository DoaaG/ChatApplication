package com.example.chatapplication.login

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.chatapplication.MainActivity
import com.example.chatapplication.R
import com.example.chatapplication.base.BaseActivity
import com.example.chatapplication.base.BaseNavigator
import com.example.chatapplication.databinding.ActivityLogInBinding
import com.example.chatapplication.databinding.ActivityRegisterBinding
import com.example.chatapplication.home.HomeActivity
import com.example.chatapplication.register.RegisterActivity
import com.example.chatapplication.register.RegisterNavigator
import com.example.chatapplication.register.RegisterViewModel

class LogInActivity : BaseActivity<LogInViewModel, ActivityLogInBinding>(), LogInNavigator {

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.dataLogin = viewModel  // linking with xml
        viewModel.loginNavigator = this

    }

    override fun getLayoutActivity(): Int = R.layout.activity_log_in

    override fun getClassViewModel(): LogInViewModel =
        ViewModelProvider(this)[LogInViewModel::class.java]

    override fun navigateToRegister() {
        var intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    override fun navigateToHome() {
        var intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)    }

}