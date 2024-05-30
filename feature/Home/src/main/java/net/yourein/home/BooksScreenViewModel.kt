package net.yourein.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.launch
import net.yourein.datasource.entities.Book
import net.yourein.librocore.repositories.BookRepository
import javax.inject.Inject

@HiltViewModel
class BooksScreenViewModel @Inject constructor(
    private val bookRepository: BookRepository,
) : ViewModel() {
    var allBooksList: ImmutableList<Book> by mutableStateOf(persistentListOf())
        private set

    init {
        updateBookList()
    }

    private fun updateBookList() {
        viewModelScope.launch {
            allBooksList = bookRepository.getAllBooks().toImmutableList()
        }
    }
}