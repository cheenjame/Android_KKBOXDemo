package com.example.kkboxdemo.model

data class TokenResponse(
    val access_token: String,
    val expires_in: Int,
    val token_type: String
)

data class ApiErrorModel(var status: Int, var message: String)
