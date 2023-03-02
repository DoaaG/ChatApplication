package com.example.chatapplication.base

interface BaseNavigator {
    fun showLoading(message : String)
    fun hide()
    fun showMessage(message :String)
}