package com.hoon.booksearch.ui.viewmodel

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import com.hoon.booksearch.data.repository.BookSearchRepository

class BookSearchViewModelProviderFactory(
    private val bookSearchRepository: BookSearchRepository,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null,
) : AbstractSavedStateViewModelFactory(owner, defaultArgs){

    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        if (modelClass.isAssignableFrom(BookSearchViewModel::class.java)) {
            return BookSearchViewModel(bookSearchRepository, handle) as T
        }
        throw IllegalArgumentException("ViewModel class not found")
    }
}