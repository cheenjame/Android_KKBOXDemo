package com.example.kkboxdemo

import android.app.Dialog
import android.content.Context

object LoadingDialog{
    private var dialog: Dialog? = null

    fun show(context: Context){
        cancel()
        dialog = Dialog(context,R.style.LoadingDialog)
        dialog?.setContentView(R.layout.dialog_loading)
        dialog?.setCancelable(false)
        dialog?.setCanceledOnTouchOutside(false)
        dialog?.show()

    }

    fun cancel(){
        dialog?.dismiss()
    }
}