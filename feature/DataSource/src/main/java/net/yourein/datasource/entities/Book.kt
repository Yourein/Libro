package net.yourein.datasource.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity data class Book(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "published_at") val publishDate: String?,
    @ColumnInfo(name = "thumbnail_url") val thumbnailUrl: String?,
    @ColumnInfo(name = "thumbnail_name") val thumbnailName: String?,
    @ColumnInfo(name = "isbn") val isbn: String?,
    @ColumnInfo(name = "registered_at") val registeredAt: Long,
    @ColumnInfo(name = "reading_status") val readingStatus: Int,
)