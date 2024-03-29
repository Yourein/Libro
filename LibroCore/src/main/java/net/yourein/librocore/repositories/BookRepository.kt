package net.yourein.librocore.repositories

import androidx.compose.ui.graphics.painter.Painter
import net.yourein.datasource.entities.Author
import net.yourein.datasource.entities.Book
import net.yourein.datasource.entities.Series
import net.yourein.datasource.entities.Tag

interface BookRepository {
    fun getAllBooks(): List<Book>
    fun getBookByIsbn(isbn: String): Book
    fun getBookByTag(tag: Tag): List<Book>
    fun getBookBySeries(series: Series): List<Book>
    fun getBookByAuthor(author: Author): List<Book>
    fun getBookthumbnail(book: Book): Painter
    fun getCurrentlyReadingBooks(): List<Book>
}