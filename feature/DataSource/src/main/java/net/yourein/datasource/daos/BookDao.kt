package net.yourein.datasource.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import net.yourein.datasource.entities.Book

@Dao
interface BookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBook(book: Book)

    @Delete
    fun deleteBook(book: Book)

    @Query("SELECT * FROM book")
    fun getAllBook(): List<Book>

    @Query("SELECT * FROM book ORDER BY registered_at DESC LIMIT 15")
    fun getRecentAddedBooks(): List<Book>

    @Query("SELECT * FROM book WHERE reading_status=1")
    fun getCurrentlyReadingBooks(): List<Book>

    @Query("SELECT * FROM book WHERE isbn=:isbn LIMIT 1")
    fun getBookByIsbn(isbn: String): Book

    @Query("SELECT * FROM book WHERE name LIKE :name")
    fun searchBookByName(name: String): List<Book>
}