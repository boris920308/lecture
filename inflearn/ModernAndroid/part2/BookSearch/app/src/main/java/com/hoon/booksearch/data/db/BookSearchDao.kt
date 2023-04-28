package com.hoon.booksearch.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.hoon.booksearch.data.model.Book

@Dao
interface BookSearchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) // db primary key 중복시 덮어쓰도록 지정
    suspend fun insertBook(book: Book)

    @Delete
    suspend fun deleteBook(book: Book)

    @Query("SELECT * FROM books")
    fun getFavoriteBooks(): LiveData<List<Book>>
}