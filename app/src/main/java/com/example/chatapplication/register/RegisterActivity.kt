package com.example.chatapplication.register

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.chatapplication.R
import com.example.chatapplication.base.BaseActivity
import com.example.chatapplication.databinding.ActivityRegisterBinding
import com.example.chatapplication.login.LogInActivity

class RegisterActivity : BaseActivity<RegisterViewModel, ActivityRegisterBinding>(), RegisterNavigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.dataRegister = viewModel // linking with xml
        viewModel.registerNavigator = this
    }


    override fun getLayoutActivity(): Int = R.layout.activity_register

    override fun getClassViewModel(): RegisterViewModel =
        ViewModelProvider(this)[RegisterViewModel::class.java]

    override fun navigate() {
        var intent = Intent(this, LogInActivity::class.java)
        startActivity(intent)
    }

    override fun goBack() {
        finish()
    }
}
