package net.yourein.librocore.repositories

import androidx.compose.ui.graphics.painter.Painter
import net.yourein.datasource.entities.Author
import net.yourein.datasource.entities.Book
import net.yourein.datasource.entities.Series
import net.yourein.datasource.entities.Tag

interface BookRepository {
    suspend fun getAllBooks(): List<Book>
    suspend fun getBookByIsbn(isbn: String): Book
    suspend fun getBookByTag(tag: Tag): List<Book>
    suspend fun getBookBySeries(series: Series): List<Book>
    suspend fun getBookByAuthor(author: Author): List<Book>
    suspend fun getBookthumbnail(book: Book): Painter
    suspend fun getCurrentlyReadingBooks(): List<Book>
}