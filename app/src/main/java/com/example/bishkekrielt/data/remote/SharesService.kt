package com.example.bishkekrielt.data.remote

import com.example.bishkekrielt.data.model.Data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SharesService {

    @GET("Bahaku/.mockend.json/db")
    suspend fun getShares(): Response<Data>

    @GET("Bahaku/.mockend.json/db")
    suspend fun getShares2(): Response<Data>

}