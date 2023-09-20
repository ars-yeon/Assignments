package com.example.imagesearchapp.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call

class SharedViewModel : ViewModel() {
    private val networkManager = NetworkManager()

    fun searchImage(query: String): Call<KakaoImageList> {
        return networkManager.searchImages(query)
    }

    private val _bookmarkedItems = MutableLiveData<Set<KakaoImage>>(setOf())
    val bookmarkedItems: LiveData<Set<KakaoImage>> = _bookmarkedItems

    fun toggleBookmark(item: KakaoImage) {
        val currentItems = _bookmarkedItems.value?.toMutableSet() ?: mutableSetOf()

        if (item in currentItems) currentItems.remove(item)
        else currentItems.add(item)

        _bookmarkedItems.value = currentItems.toSet()
    }

    init {
        bookmarkedItems.observeForever { items ->
            Log.d("SharedViewModel", "Bookmarked items: ${items.size}개, $items")
        }
    }
}