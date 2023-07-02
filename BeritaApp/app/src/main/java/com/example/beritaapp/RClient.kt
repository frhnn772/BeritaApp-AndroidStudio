package com.example.beritaapp

import android.app.TaskStackBuilder.create
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RClient {
    private const val BASE_URL = "https://syafii-2520.herokuapp.com/";
    val rService: RService
    get() {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient
                .Builder()
                .addInterceptor(interceptor)
                .build()
        val retrofit = Retrofit
                .Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client((client))
                .build()
        return  retrofit.create(RService::class.java)
    }
}