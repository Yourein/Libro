package net.yourein.datasource.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity data class Bookshelf(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
)

@Entity data class BookShelfBook(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "book_id") val bookId: Int,
    @ColumnInfo(name = "bookshelf_id") val bookshelfId: Int,
)