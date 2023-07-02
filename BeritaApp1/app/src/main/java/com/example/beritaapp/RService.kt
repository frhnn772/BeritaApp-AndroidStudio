package com.example.beritaapp

import retrofit2.Call
import retrofit2.http.GET


interface RService {
    @GET("getListBerita")
        fun getBeritas(): Call<ResponseModel>
}