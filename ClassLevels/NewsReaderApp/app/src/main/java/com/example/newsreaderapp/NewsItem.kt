package com.example.newsreaderapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.LocalDateTime

@Parcelize
data class NewsItem(
    val img: String,
    val agency:String,
    val date: LocalDateTime,
    val title: String,
    val content: String,
    var bookmark: Boolean
) : Parcelable
