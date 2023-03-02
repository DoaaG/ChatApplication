package com.example.chatapplication.register

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.chatapplication.base.BaseViewModel
import com.example.chatapplication.isValidEmail
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterViewModel : BaseViewModel<RegisterNavigator>() {
    //  val auth =  FirebaseAuth.getInstance()
    private var auth: FirebaseAuth = Firebase.auth
    var registerNavigator: RegisterNavigator? = null


    var firstName = ObservableField<String?>()
    var lastName = ObservableField<String?>()
    var email = ObservableField<String?>()
    var password = ObservableField<String?>()

    var firstNameError = ObservableField<String?>()
    var lastNameError = ObservableField<String?>()
    var emailError = ObservableField<String?>()
    var passwordError = ObservableField<String?>()


    fun createAccount() {
        if (!isValid()) {
            navigator?.showMessage("Invalid Account")
            return
        }
        navigator?.showLoading("Loading")
        auth.createUserWithEmailAndPassword(email.get()!!, password.get()!!)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    navigator?.showMessage("Account created successfully")
                    navigateToLogin()
                } else {
                    navigator?.showMessage("${it.exception?.message}")
                }
            }
//        registerNavigator?.hide()

    }

    fun isValid(): Boolean {
        var valid = true
        if (firstName.get().isNullOrBlank()) {
            valid = false
            firstNameError.set("Please Enter a Valid FirstName")
        } else {
            firstNameError.set(null)
        }


        if (lastName.get().isNullOrBlank()) {
            valid = false
            lastNameError.set("Please Enter a Valid LastName")
        } else {
            lastNameError.set(null)
        }

        if (email.get().isNullOrBlank()) {
            valid = false
            emailError.set("Please Enter a Valid Email")
        } else if (email.get()?.isValidEmail() == false) {
            emailError.set("Please Enter a Valid Email")
        } else {
            emailError.set(null)
        }

        if (password.get().isNullOrBlank()) {
            valid = false
            passwordError.set("Please Enter a Valid Password")
        } else {
            passwordError.set(null)
        }

        return valid
    }

    fun navigateToLogin() {
        registerNavigator?.navigate()
    }

    fun finish() {
        registerNavigator?.goBack()
    }
}