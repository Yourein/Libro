package net.yourein.datasource.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity data class Tag(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String
)

@Entity data class BookTag(
    @PrimaryKey(autoGenerate = true) val id: Int, // This property can not be used.
    @ColumnInfo(name = "book_id") val bookId: Int,
    @ColumnInfo(name = "tag_id") val tagId: Int,
)