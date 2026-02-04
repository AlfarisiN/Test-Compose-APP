package com.example.testapp.network

import com.example.testapp.model.userlogin.ResponseLogin
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiServices {

    @FormUrlEncoded
    @POST("login/v2")
    suspend fun login(
        @Field("username") username : String,
        @Field("password") password : String,
        @Field("app") app : String
    ) : ResponseLogin

//    @FormUrlEncoded
//    @POST("userprofile")
//    suspend fun profile(
//        @Field("username") username : String
//    ) :

}