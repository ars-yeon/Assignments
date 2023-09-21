package com.example.imagesearchapp.data

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Call

class SharedViewModel : ViewModel() {
    private val networkManager = NetworkManager()

    fun searchImage(query: String): Call<KakaoImageList> {
        return networkManager.searchImages(query)
    }

    private val _bookmarkedItems = MutableLiveData<Set<KakaoImage>>(setOf())
    val bookmarkedItems: LiveData<Set<KakaoImage>> = _bookmarkedItems

    fun toggleBookmark(context: Context, item: KakaoImage) {
        val currentItems = _bookmarkedItems.value?.toMutableSet() ?: mutableSetOf()

        if (item in currentItems) currentItems.remove(item)
        else currentItems.add(item)

        _bookmarkedItems.value = currentItems.toSet()
        saveBookmarks(context)
    }

    private fun saveBookmarks(context: Context) {
        val pref = context.getSharedPreferences("bookmark_prefs", Context.MODE_PRIVATE)
        val editor = pref.edit()
        val bookmarkedItemsSet = _bookmarkedItems.value ?: setOf()
        val bookmarkedItemsJson = Gson().toJson(bookmarkedItemsSet.toList())
        editor.putString("bookmarked_items", bookmarkedItemsJson)
        editor.apply()
    }

    fun loadBookmarks(context: Context) {
        val pref = context.getSharedPreferences("bookmark_prefs", Context.MODE_PRIVATE)
        val bookmarkedItemsJson = pref.getString("bookmarked_items", null)

        if (bookmarkedItemsJson != null) {
            val typeToken = object : TypeToken<Set<KakaoImage>>() {}.type
            val bookmarkedItemsSet = Gson().fromJson<Set<KakaoImage>>(bookmarkedItemsJson, typeToken)
            _bookmarkedItems.value = bookmarkedItemsSet
        }
    }

    init {
        bookmarkedItems.observeForever { items ->
            Log.d("SharedViewModel", "Bookmarked items: ${items.size}개, $items")
        }
    }
}