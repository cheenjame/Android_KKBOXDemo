package com.example.kkboxdemo

import android.content.Context
import io.reactivex.disposables.Disposable
import java.util.*

abstract class ApiResponse<T>(private val context: Context) : Observer<T>{
    abstract fun success(data: T)
    abstract fun failure(statusCode: Int,apiErrorModel: ApiErrorModel)

    override fun onSubscribe(d: Disposable){
        LoadingDialog.show(context)
    }

}