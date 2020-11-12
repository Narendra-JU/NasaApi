package com.example.nasaapi.network

import com.example.nasaapi.model.ApodData
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitAopdService {
    @GET("/planetary/apod?api_key=tuWNJbXMXRtZmfgcyMHeNiQikaJzJTEMLc5F8bUQ")


    suspend fun getApodDataAsync():ApodData
}