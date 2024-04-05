package net.yourein.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.painter.Painter
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
class HomeViewModel @Inject constructor(
    private val bookRepository: BookRepository,
) : ViewModel() {
    var currentlyReadingBooks: ImmutableList<Book> by mutableStateOf(persistentListOf())

    init {
        updateCurrentlyReadingBooks()
    }

    fun updateCurrentlyReadingBooks() {
        viewModelScope.launch {
            currentlyReadingBooks =
                bookRepository.getCurrentlyReadingBooks()
                    .toImmutableList()
        }
    }

    @Composable
    fun getBookThumbnail(book: Book): Painter? {
        return bookRepository.getBookThumbnail(book = book)
    }
}