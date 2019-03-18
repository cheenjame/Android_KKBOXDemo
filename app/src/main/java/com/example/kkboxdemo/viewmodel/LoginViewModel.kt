package com.example.kkboxdemo.viewmodel

import android.arch.lifecycle.ViewModel
import android.content.Context
import android.content.Intent
import android.databinding.Bindable
import android.databinding.ObservableInt
import android.support.v4.content.ContextCompat.startActivity
import android.widget.Toast
import com.android.databinding.library.baseAdapters.BR
import com.example.kkboxdemo.model.*
import com.example.kkboxdemo.view.MainActivity
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.kotlin.bindUntilEvent
import java.time.Instant
import java.util.*

class LoginViewModel() : ObservableViewModel() {

}