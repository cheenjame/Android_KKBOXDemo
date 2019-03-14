package com.example.kkboxdemo

import io.reactivex.Flowable
import io.reactivex.internal.operators.flowable.FlowableAll
import retrofit2.http.Field
import retrofit2.http.POST

interface KKBoxService{

    @POST("token")
    fun getToken(@Field("grant_type") grant_type: String,
                 @Field("client_id") client_id: String,
                 @Field("client_secret") client_secret: String):Flowable<TokenResponse>

}