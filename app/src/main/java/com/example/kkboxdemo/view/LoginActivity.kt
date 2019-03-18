package com.example.kkboxdemo.view

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kkboxdemo.R
import com.example.kkboxdemo.databinding.ActivityLoginBinding
import com.example.kkboxdemo.model.*
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.kotlin.bindUntilEvent
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity


class LoginActivity : RxAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    fun init() {
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.btnLoginIntent.setOnClickListener {
            ApiClient.instance.service.getToken(
                "","",""
            )
                .compose(NetworkScheduler.compose())
                .bindUntilEvent(this, ActivityEvent.DESTROY)
                .subscribe(object : ApiResponse<TokenResponse>(this) {
                    override fun success(data: TokenResponse) {

                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))

                        Toast.makeText(this@LoginActivity, data.access_token, Toast.LENGTH_SHORT).show()

                    }

                    override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {
                        Toast.makeText(this@LoginActivity, apiErrorModel.message, Toast.LENGTH_SHORT).show()
                    }
                })


        }

    }

}
