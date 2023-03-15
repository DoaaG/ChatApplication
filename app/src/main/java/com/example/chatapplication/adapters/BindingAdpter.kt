package com.example.chatapplication.adapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout
import com.google.type.Date

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
    textView.text = time
}