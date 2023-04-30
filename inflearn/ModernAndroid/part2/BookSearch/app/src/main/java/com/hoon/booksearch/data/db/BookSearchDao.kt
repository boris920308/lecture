package com.hoon.booksearch.data.db

import androidx.room.*
import com.hoon.booksearch.data.model.Book
import kotlinx.coroutines.flow.Flow

@Dao
interface BookSearchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) // db primary key 중복시 덮어쓰도록 지정
    suspend fun insertBook(book: Book)

    @Delete
    suspend fun deleteBook(book: Book)

    @Query("SELECT * FROM books")
    fun getFavoriteBooks(): Flow<List<Book>>
}