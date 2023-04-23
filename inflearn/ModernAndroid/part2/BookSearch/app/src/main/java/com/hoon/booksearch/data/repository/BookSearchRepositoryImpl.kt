package com.hoon.booksearch.data.repository

import com.hoon.booksearch.data.api.RetrofitInstance.api
import com.hoon.booksearch.data.model.SearchResponse
import retrofit2.Response

class BookSearchRepositoryImpl : BookSearchRepository{
    override suspend fun searchBooks(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): Response<SearchResponse> {
        return api.searchBooks(query, sort, page, size)
    }
}