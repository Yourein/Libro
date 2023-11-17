package net.yourein.datasource.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity data class Series(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "author") val author: String?,
)

@Entity data class SeriesBook(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "series_id") val seriesId: Int,
    @ColumnInfo(name = "book_id") val bookId: Int,
)