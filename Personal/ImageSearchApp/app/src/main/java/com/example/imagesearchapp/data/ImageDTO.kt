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
    val datetime: String,
    var isBookmarked: Boolean = false,
    var collectionFragment: String = ""
) {
    val uniqueIdentifier: String
        get() = thumbnailUrl

    override fun hashCode(): Int {
        return uniqueIdentifier.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is KakaoImage) return false

        return uniqueIdentifier == other.uniqueIdentifier
    }
}

data class KakaoImageList(
    @SerializedName("documents")
    val data: List<KakaoImage>
)