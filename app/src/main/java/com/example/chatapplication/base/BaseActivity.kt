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

open abstract class BaseActivity<viewModel : ViewModel, binding : ViewDataBinding> :
    AppCompatActivity() {
    lateinit var binding: binding
    lateinit var viewModel: viewModel
    var alertDialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutActivity())
        viewModel = getClassViewModel()

    }

    abstract fun getLayoutActivity(): Int
    abstract fun getClassViewModel(): viewModel


    fun showMessage(
        message: String,
        positiveActionTitle: String? = null,
        positiveAction: DialogInterface.OnClickListener? = null,
        negativeActionTitle: String? = null,
        negativeAction: DialogInterface.OnClickListener? = null,
        cancelable: Boolean = true
    ) {
        var messageDialogBuilder = AlertDialog.Builder(this)
        messageDialogBuilder.setMessage(message)

        if (positiveActionTitle != null) {
            messageDialogBuilder.setPositiveButton(
                positiveActionTitle,
                positiveAction ?: DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                })
        }
        if (negativeActionTitle != null) {
            messageDialogBuilder.setNegativeButton(
                negativeActionTitle,
                negativeAction ?: DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                })
        }
        messageDialogBuilder.setCancelable(cancelable)
        alertDialog = messageDialogBuilder.show()

    }



}
/**
override fun getLayoutActivity(): Int = R.layout.activity_register
override fun getClassViewModel(): ViewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

override fun getLayoutActivity(): Int = R.layout.activity_log_in
override fun getClassViewModel(): ViewModel = ViewModelProvider(this)[LogInViewModel::class.java]
 */
