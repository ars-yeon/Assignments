package com.example.newsreaderapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Parcelize
data class NewsItem(
    val img: Int,
    val agency:String,
    val date: LocalDateTime,
    val title: String,
    val content: String,
    var bookmark: Boolean
) : Parcelable {
    val formattedDate: String
        get() {
            val formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm")
            return date.format(formatter)
        }
}
