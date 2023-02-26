package com.example.chatapplication.register

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.chatapplication.R
import com.example.chatapplication.base.BaseActivity
import com.example.chatapplication.databinding.ActivityRegisterBinding

class RegisterActivity : BaseActivity<RegisterViewModel, ActivityRegisterBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.dataRegister = viewModel // linking with xml
//        binding.backArrow.setOnClickListener{
//            finish()
//        }
    }



    override fun getLayoutActivity(): Int = R.layout.activity_register

    override fun getClassViewModel(): RegisterViewModel = ViewModelProvider(this)[RegisterViewModel::class.java]

}

//var firstName = binding.editTextFirstname.text.toString()
//var lastNameError = binding.editTextLastname.text.toString()
//var emailError = binding.editTextEmailAddress.text.toString()
//var passwordError = binding.editTextPasswordCreateAcc.text.toString()
//
//fun isValid(): Boolean {
//    var valid = true
//    if (firstNameError.isNullOrBlank()) {
//        valid = false
//        binding.editTextFirstname.error = "Please Enter a Valid FirstName"
//    } else {
//        binding.editTextFirstname.error  = null
//    }
//
//
//    if (lastName.isNullOrBlank()) {
//        valid = false
//        binding.editTextLastname.error = "Please Enter a Valid LastName"
//    } else {
//        binding.editTextLastname.error  = null
//    }
//
//    if (email.isNullOrBlank()) {
//        valid = false
//        binding.editTextEmailAddress.error = "Please Enter a Valid Email"
//    } else {
//        binding.editTextEmailAddress.error = null
//    }
//
//    if (password.isNullOrBlank()) {
//        valid = false
//        binding.editTextPasswordCreateAcc.error = "Please Enter a Valid Password"
//    } else {
//        binding.editTextPasswordCreateAcc.error = null
//    }
//
//    return valid
//}