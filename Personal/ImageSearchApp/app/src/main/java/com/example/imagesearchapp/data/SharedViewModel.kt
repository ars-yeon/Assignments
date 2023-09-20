package com.example.imagesearchapp.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call

class SharedViewModel: ViewModel() {
    private val networkManager = NetworkManager()

    fun searchImage(query: String): Call<KakaoImageList> {
        return networkManager.searchImages(query)
    }

    private val _bookmarkedItems = MutableLiveData<Set<KakaoImage>>(setOf())
    val bookmarkedItems: LiveData<Set<KakaoImage>> = _bookmarkedItems

    fun toggleBookmark(item: KakaoImage) {
        val currentItems  = bookmarkedItems.value ?: setOf()
        val updatedItems  = currentItems.toMutableSet()

        if (item in updatedItems ) {
            updatedItems.remove(item)
        } else {
            updatedItems.add(item)
        }

        _bookmarkedItems.value = updatedItems
    }

    init {
        // 북마크 아이템이 추가/제거될 때 로그 출력
        bookmarkedItems.observeForever { items ->
            Log.d("SharedViewModel", "Bookmarked items: ${items.size}개, $items")
        }
    }
}