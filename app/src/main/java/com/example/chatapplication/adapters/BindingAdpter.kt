package com.example.chatapplication.adapters

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("error")
fun addTextInputError(textInputLayout: TextInputLayout,error:String?){
    textInputLayout.error = error
}