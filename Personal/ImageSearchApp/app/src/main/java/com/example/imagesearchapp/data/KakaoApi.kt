package com.example.imagesearchapp.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface KakaoApi {
    @GET("v2/search/image")
    fun searchImage(
        @Query("query") query: String
    ): Call<KakaoImageList>
}