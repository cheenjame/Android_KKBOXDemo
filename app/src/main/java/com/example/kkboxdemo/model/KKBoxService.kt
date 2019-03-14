package com.example.kkboxdemo.model

import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface KKBoxService{

    @FormUrlEncoded
    @POST("token")
    fun getToken(@Field("grant_type") grant_type: String,
                 @Field("client_id") client_id: String,
                 @Field("client_secret") client_secret: String): Observable<TokenResponse>

}