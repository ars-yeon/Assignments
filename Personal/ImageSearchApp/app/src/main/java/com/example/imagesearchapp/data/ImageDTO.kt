package com.example.imagesearchapp.data

import com.google.gson.annotations.SerializedName

data class KakaoImage(
    val collection: String,
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("display_sitename")
    val siteName: String,
    @SerializedName("doc_url")
    val docUrl: String,
    val datetime: String
)

data class KakaoImageList(
    @SerializedName("documents")
    val data: List<KakaoImage>
)