package com.example.kkboxdemo.viewmodel

import android.arch.lifecycle.ComputableLiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import android.content.Intent
import android.databinding.Bindable
import android.databinding.ObservableInt
import android.support.v4.content.ContextCompat.startActivity
import android.view.View
import android.widget.Toast
import com.android.databinding.library.baseAdapters.BR
import com.example.kkboxdemo.model.*
import com.example.kkboxdemo.view.KkboxNavigationActivity
import com.example.kkboxdemo.view.MainActivity
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.kotlin.bindUntilEvent
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.time.Instant
import java.util.*

class LoginViewModel() : ObservableViewModel() {
    val like = Observable()


    fun getToken() {
        like.intcrement()
    }

    private fun Observable.intcrement() {
//        Http.retrofit.getToken("", "", "").observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(Schedulers.newThread())
//            .subscribe({ reult ->
//              if(reult.error.equals("")){
//                  reult.access_token
//
//              }else {
//                  reult.error
//              }
//
//            },
//                { e -> e.message }
//
//            )

    }



}
