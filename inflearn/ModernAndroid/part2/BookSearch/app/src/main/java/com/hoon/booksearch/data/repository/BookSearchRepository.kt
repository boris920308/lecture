package com.hoon.booksearch.data.repository

import androidx.lifecycle.LiveData
import com.hoon.booksearch.data.model.Book
import com.hoon.booksearch.data.model.SearchResponse
import retrofit2.Response

interface BookSearchRepository {

    suspend fun searchBooks(
        query: String,
        sort: String,
        page: Int,
        size: Int,
    ): Response<SearchResponse>

    // room
    suspend fun insertBooks(book: Book)

    suspend fun deleteBooks(book: Book)

    fun getFavoriteBooks(): LiveData<List<Book>>

}