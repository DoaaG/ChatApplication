package com.example.chatapplication.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel<Nav> : ViewModel() {
    var navigator : BaseNavigator? = null
}