package com.hoon.booksearch.data.repository

import androidx.paging.PagingData
import com.hoon.booksearch.data.model.Book
import com.hoon.booksearch.data.model.SearchResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import retrofit2.Response

class FakeBookSearchRepository : BookSearchRepository {

    private val bookItem = mutableListOf<Book>()

    override suspend fun searchBooks(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): Response<SearchResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun insertBooks(book: Book) {
        bookItem.add(book)
    }

    override suspend fun deleteBooks(book: Book) {
        bookItem.remove(book)
    }

    override fun getFavoriteBooks(): Flow<List<Book>> {
        return flowOf(bookItem)
    }

    override suspend fun saveSortMode(mode: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getSortMode(): Flow<String> {
        TODO("Not yet implemented")
    }

    override suspend fun saveCacheDeleteMode(mode: Boolean) {
        TODO("Not yet implemented")
    }

    override suspend fun getCacheDeleteMode(): Flow<Boolean> {
        TODO("Not yet implemented")
    }

    override fun getFavoritePagingBooks(): Flow<PagingData<Book>> {
        TODO("Not yet implemented")
    }

    override fun searchBooksPaging(query: String, sort: String): Flow<PagingData<Book>> {
        TODO("Not yet implemented")
    }
}