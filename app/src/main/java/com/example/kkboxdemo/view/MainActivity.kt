package com.example.kkboxdemo.view

import android.os.Bundle
import android.widget.Toast
import com.example.kkboxdemo.*
import com.example.kkboxdemo.model.*
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import com.trello.rxlifecycle2.kotlin.bindUntilEvent

class MainActivity : RxAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LoginToken()
    }

    private fun LoginToken(){
        ApiClient.instance.service.getToken()
            .compose(NetworkScheduler.compose())                         //线程切换处理
            .bindUntilEvent(this , ActivityEvent.DESTROY)
            .subscribe(object : ApiResponse<TokenResponse>(this){
                override fun success(data: TokenResponse) {
                    Toast.makeText(this@MainActivity , data.access_token,Toast.LENGTH_SHORT).show()
                }

                override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {
                    Toast.makeText(this@MainActivity , apiErrorModel.message,Toast.LENGTH_SHORT).show()
                }
            })

    }
}
