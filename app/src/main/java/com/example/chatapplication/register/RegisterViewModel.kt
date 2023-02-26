package com.example.chatapplication.register

import android.app.AlertDialog
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterViewModel :ViewModel() {

    private var auth: FirebaseAuth = Firebase.auth

    var firstName : String =""
    var lastName : String =""
    var email : String =""
    var password : String =""

    var firstNameError : String =""
    var lastNameError : String =""
    var emailError : String =""
    var passwordError : String =""


    fun createAccount() {
//        if (!isValid()) {
//            Log.e("createAccount","false")
//            return
//        }
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    Log.e("createAccount", "signInWithEmail:success")
                    Log.e("createAccount", "$firstName  $lastName  $email  $password")

                }
                else{
                    Log.e("createAccount", "signInWithEmail:failure ${it.exception?.message}")
                }
            }

    }
    fun isValid(): Boolean {
        var valid = true
        if (firstName.isNullOrBlank()) {
            valid = false
            firstNameError = "Please Enter a Valid FirstName"
        } else {
            firstName = ""
        }


        if (lastName.isNullOrBlank()) {
            valid = false
            lastNameError = "Please Enter a Valid LastName"
        } else {
            lastName = ""
        }

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