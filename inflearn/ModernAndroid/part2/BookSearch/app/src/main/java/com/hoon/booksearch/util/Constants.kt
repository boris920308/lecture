package com.hoon.booksearch.util

import com.hoon.booksearch.BuildConfig

object Constants {
    const val BASE_URL = "https://dapi.kakao.com"
    const val API_KEY = BuildConfig.kakaoApiKey
    const val SEARCH_BOOKS_TIME_DELAY = 100L
    const val DATASTORE_NAME = "preferences_datastore"
}