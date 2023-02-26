package com.example.chatapplication.login

import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import com.example.chatapplication.base.BaseViewModel
import com.example.chatapplication.register.RegisterActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LogInViewModel : BaseViewModel() {
    private var auth: FirebaseAuth = Firebase.auth

    var email : String =""
    var password : String =""

    var emailError : String =""
    var passwordError : String =""

    fun login(){
//        if (!isValid()) {
//            Log.e("createAccount","false")
//            return
//        }
        isLoadingLiveData.value = true
            auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener {
                    isLoadingLiveData.value = false
                    if(it.isSuccessful){
                      dialogMessageLiveData.value = "Successful Login"
                        Log.e("createAccount", "logInWithEmail:success")
                        Log.e("createAccount", "$email  $password")

                    }
                    else{
                        dialogMessageLiveData.value = it.exception?.message
                        Log.e("createAccount", "logInWithEmail:failure ${it.exception?.message}")
                    }
                }
    }

    fun isValid(): Boolean {
        var valid = true

        if (email.isNullOrBlank()) {
            valid = false
            emailError = "Please Enter a Valid Email"
        } else {
            email = ""
        }

        if (password.isNullOrBlank()) {
            valid = false
            passwordError = "Please Enter a Valid Password"
        } else {
            password = ""
        }

        return valid
    }

}