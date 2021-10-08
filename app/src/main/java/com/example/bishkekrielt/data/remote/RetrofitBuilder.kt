package com.example.bishkekrielt.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitBuilder {

    private var service: SharesService? = null

    fun getService(): SharesService? {
        if (service == null)
            service = buildRetrofit()

        return service
    }


    fun buildRetrofit(): SharesService{
        return Retrofit.Builder()
                //.baseUrl("http://api.openweathermap.org/")
                .baseUrl("http://my-json-server.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build()
                .create(SharesService::class.java)
    }


    private fun getClient(): OkHttpClient{
        return OkHttpClient.Builder()
                .connectTimeout(10,TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .addInterceptor(provideLoggingInterceptor())
                .build()
    }

    private fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY
        return logger
    }
}
