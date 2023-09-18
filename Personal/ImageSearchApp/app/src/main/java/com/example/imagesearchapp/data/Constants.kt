package com.example.imagesearchapp.data

import com.example.imagesearchapp.BuildConfig

class Constants {
    companion object {
        const val BASE_URL = BuildConfig.kakao_api_url
        const val AUTH_HEADER = "KakaoAK ${BuildConfig.kakao_rest_api_key}"
    }
}