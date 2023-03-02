package com.example.chatapplication.adapters

import android.content.Context
import android.content.Intent
import android.widget.Button
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.BindingAdapter
import com.example.chatapplication.register.RegisterActivity
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("error")
fun addTextInputError(textInputLayout: TextInputLayout,error:String?){
    textInputLayout.error = error
}