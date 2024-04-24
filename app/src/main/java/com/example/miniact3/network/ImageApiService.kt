package com.example.miniact3.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

    private const val BASE_URL = "https://s.inyourpocket.com"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
    interface ImageApiService {
        @GET("/gallery/113383.jpg")
        suspend fun getPhotos():String
    }
    object ImageApi {
        val retrofitService:ImageApiService by lazy {
            retrofit.create(ImageApiService::class.java)
        }
    }