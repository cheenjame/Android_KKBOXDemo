package com.example.kkboxdemo.model

import android.app.Application

class App: Application(){
    override fun onCreate() {
        super.onCreate()

        ApiClient.instance.init()
    }
}