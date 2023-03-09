package com.example.koinexample.data.network

import com.example.koinexample.data.models.Media
import retrofit2.http.GET

interface ApiInterface {

    @GET("test.json")
    suspend fun getMedias(): Media
}