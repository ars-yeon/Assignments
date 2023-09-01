package com.example.newsreaderapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.LocalDate

@Parcelize
data class NewsItem(
    val img: String,
    val agency:String,
    val date: LocalDate,
    val title: String,
    val content: String,
    var bookmark: Boolean
) : Parcelable
