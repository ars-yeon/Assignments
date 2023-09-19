package com.example.imagesearchapp.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SharedViewModel: ViewModel() {
    private val _bookmarkedItems = MutableLiveData<Set<KakaoImage>>(setOf())
    private val bookmarkedItems: LiveData<Set<KakaoImage>> = _bookmarkedItems

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

    fun toggleBookmark(item: KakaoImage) {
        val currentItems  = bookmarkedItems.value ?: setOf()
        val updatedItems  = currentItems.toMutableSet()

        if (item in updatedItems ) {
            updatedItems .remove(item)
        } else {
            updatedItems .add(item)
        }

        _bookmarkedItems.value = updatedItems
    }

    fun getBookmarkedItems(): LiveData<Set<KakaoImage>> {
        return bookmarkedItems
    }

    init {
        // 북마크 아이템이 추가/제거될 때 로그 출력
        bookmarkedItems.observeForever { items ->
            Log.d("SharedViewModel", "Bookmarked items: ${items.size}개, $items")
        }
    }
}