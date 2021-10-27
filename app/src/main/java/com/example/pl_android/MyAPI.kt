package com.example.pl_android

import retrofit2.*
import retrofit2.http.GET

interface MyAPI {

    @GET("/comments")
    fun getComments_v2(): Response<List<Comment>>

    @GET("/comments")
    suspend fun getComments_v1(): Call<List<Comment>>

}