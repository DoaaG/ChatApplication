package com.example.chatapplication.base

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chatapplication.register.RegisterViewModel

open abstract class BaseActivity<viewModel : BaseViewModel<*>, binding : ViewDataBinding> :
    AppCompatActivity(),BaseNavigator {
    lateinit var binding: binding
    lateinit var viewModel: viewModel
    var alertDialog: AlertDialog? = null
    var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutActivity())
        viewModel = getClassViewModel()
        viewModel.navigator = this
    }

    abstract fun getLayoutActivity(): Int
    abstract fun getClassViewModel(): viewModel

    override fun showLoading(message: String) {
        progressDialog = ProgressDialog(this)
        progressDialog?.setMessage(message)
        progressDialog?.show()
    }

    override fun hide() {
        progressDialog?.dismiss()
        progressDialog = null
        alertDialog?.dismiss()
    }

    override fun showMessage(message: String) {
        alertDialog =
            AlertDialog.Builder(this)
                .setMessage(message).setPositiveButton("Ok")
                { dialogInterface, i -> dialogInterface.dismiss() }.show()
    }

}

