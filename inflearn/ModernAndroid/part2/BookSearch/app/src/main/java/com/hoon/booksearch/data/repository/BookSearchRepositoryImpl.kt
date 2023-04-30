package com.hoon.booksearch.data.repository

import com.hoon.booksearch.data.api.RetrofitInstance.api
import com.hoon.booksearch.data.db.BookSearchDatabase
import com.hoon.booksearch.data.model.Book
import com.hoon.booksearch.data.model.SearchResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class BookSearchRepositoryImpl(
    private val db: BookSearchDatabase
) : BookSearchRepository{
    override suspend fun searchBooks(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): Response<SearchResponse> {
        return api.searchBooks(query, sort, page, size)
    }

    override suspend fun insertBooks(book: Book) {
        db.bookSearchDao().insertBook(book)
    }

    override suspend fun deleteBooks(book: Book) {
        db.bookSearchDao().deleteBook(book)
    }

    override fun getFavoriteBooks(): Flow<List<Book>> {
        return db.bookSearchDao().getFavoriteBooks()
    }
}