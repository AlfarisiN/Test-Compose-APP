package com.example.testapp.network

object RetrofitClient {

    private const val BaseURL = "http://10.0.2.2:8080/inms-api/"

    val api: AuthApi by lazy {
        retrofit2.Retrofit.Builder()
            .baseUrl(BaseURL)
            .addConverterFactory(
                retrofit2.converter.gson.GsonConverterFactory.create()
            )
            .build()
            .create(AuthApi::class.java)

    }

}