package com.hoon.booksearch.ui.viewmodel

import androidx.test.filters.MediumTest
import com.google.common.truth.Truth.assertThat
import com.hoon.booksearch.data.model.Book
import com.hoon.booksearch.data.repository.FakeBookSearchRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test


@MediumTest
class BookViewModelTest {

    private lateinit var viewModel: BookViewModel


    @Before
    fun setUp() {
        viewModel = BookViewModel(FakeBookSearchRepository())
        // production에서는 viewmodel이 singlton이어야 해서 factory를 만들었지만 테스트에선 그럴필요없음
    }

    @Test
    @ExperimentalCoroutinesApi
    fun save_book_test() = runTest {
        val book = Book(
            listOf("a"), "b", "c", "d", 0, "e",
            0, "f", "g", "h", listOf("i"), "j"
        )
        viewModel.saveBook(book)

        val favoriteBooks = viewModel.favoriteBooks.first()
        assertThat(favoriteBooks).contains(book)

    }
}