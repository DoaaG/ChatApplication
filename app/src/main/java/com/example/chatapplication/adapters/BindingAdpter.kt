package com.example.chatapplication.adapters

import android.content.Context
import android.content.Intent
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.BindingAdapter
import com.example.chatapplication.register.RegisterActivity
import com.google.android.material.textfield.TextInputLayout
import com.google.type.Date
import com.google.type.DateTime

@BindingAdapter("error")
fun addTextInputError(textInputLayout: TextInputLayout,error:String?){
    textInputLayout.error = error
}

@BindingAdapter("setImage")
fun setImage(imageView: ImageView,imageId:Int){
    imageView.setImageResource(imageId)
}

@BindingAdapter("setTime")
fun setTime(textView: TextView,time: String){
    textView.append(time)
}