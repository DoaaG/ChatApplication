package com.example.chatapplication.login

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.chatapplication.UserProvider
import com.example.chatapplication.base.BaseNavigator
import com.example.chatapplication.base.BaseViewModel
import com.example.chatapplication.database.FireStoreUtils
import com.example.chatapplication.database.models.User
import com.example.chatapplication.isValidEmail
import com.example.chatapplication.register.RegisterNavigator
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LogInViewModel : BaseViewModel<LogInNavigator>()  // for base functions
{
    private var auth: FirebaseAuth = Firebase.auth
    var loginNavigator: LogInNavigator? = null  // for navigating through pages

    var email = ObservableField<String?>()
    var password = ObservableField<String?>()
    var emailError = ObservableField<String?>()
    var passwordError = ObservableField<String?>()


    fun login() {
        if (!isValid()) {
            navigator?.showMessage("Login Fail")
            return
        }
        navigator?.showLoading("Loading")
        auth.signInWithEmailAndPassword(email.get()!!, password.get()!!)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    getUsersFromDataBase(it.result.user?.uid)

                } else {
                    navigator?.showMessage("${it.exception?.message}")
                    loginNavigator?.hide()
                }
            }
//        loginNavigator?.hide()

    }

    private fun getUsersFromDataBase(uid: String?) {
        FireStoreUtils().getUserFromDataBase(uid!!).addOnCompleteListener {
            navigator?.hide()
        if (it.isSuccessful) {
            val user = it.result.toObject(User::class.java)
            UserProvider.user = user
            navigateToHome()
            navigator?.showMessage("Successful Login")
        } else {
            navigator?.showMessage(it.exception?.localizedMessage ?: "")
        }

    }
}

    fun createNewAccount() {
        loginNavigator?.navigateToRegister()
    }

    fun navigateToHome() {
        loginNavigator?.navigateToHome()
    }

    fun isValid(): Boolean {
        var valid = true

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

}