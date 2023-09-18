 package com.example.imagesearchapp.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ViewModel: ViewModel() {
    val selectedItem = MutableLiveData<List<KakaoImage>>()
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

    fun searchImage(query: String): Call<KakaoImageList> {
        return api.searchImage(query)
    }
}