package com.example.api_all_method.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {

    private const val BASE_URL = "https://gorest.co.in/public/v2/"

    fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}