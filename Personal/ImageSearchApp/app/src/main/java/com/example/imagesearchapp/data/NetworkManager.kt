package com.example.imagesearchapp.data

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkManager {
    private val networkClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val originRequire = chain.request()
            val newRequire = originRequire.newBuilder()
                .addHeader("Authorization", Constants.AUTH_HEADER)
                .build()
            chain.proceed(newRequire)
        }.build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(networkClient)
        .build()

    private val api: KakaoApi = retrofit.create(KakaoApi::class.java)

    fun searchImages(query: String): Call<KakaoImageList> {
        return api.searchImage(query)
    }
}