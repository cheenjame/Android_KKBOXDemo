package com.example.kkboxdemo.view

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.widget.Toast
import com.example.kkboxdemo.R
import com.example.kkboxdemo.databinding.ActivityLoginBinding
import com.example.kkboxdemo.model.*
import com.example.kkboxdemo.viewmodel.LoadingDialog
import com.example.kkboxdemo.viewmodel.LoginViewModel
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import com.trello.rxlifecycle2.kotlin.bindUntilEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.plugins.RxJavaPlugins.onError
import io.reactivex.schedulers.Schedulers
import java.lang.Exception


class LoginActivity : RxAppCompatActivity() {
    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    fun init() {
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding.viewmodel = viewModel

        binding.btnLoginIntent.setOnClickListener {
            LoadingDialog.show(this)

            disposable = Http.retrofit.getToken(
                "",
                "",
                ""
            ).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map {
                    if (it.access_token == null) {
                        Toast.makeText(this@LoginActivity, it.error, Toast.LENGTH_SHORT).show()

                    }
                    it
                }
                .subscribe({
                    it.access_token
                    if (!it.access_token.equals("")) {

                        startActivity(Intent(this@LoginActivity, KkboxNavigationActivity::class.java))
                        LoadingDialog.cancel()

                    }

                },
                    { e ->
                        e.message
//                        Toast.makeText(this@LoginActivity, e.message, Toast.LENGTH_SHORT).show()
                        LoadingDialog.cancel()


                    })

        }

    }

    override fun onPause() {
        super.onPause()
        LoadingDialog.cancel()

        disposable?.dispose()
    }

}
