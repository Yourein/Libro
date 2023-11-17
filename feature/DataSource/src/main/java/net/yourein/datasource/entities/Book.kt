package net.yourein.datasource.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity data class Book(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "author") val author: String?,
    @ColumnInfo(name = "published_at") val publishDate: String?,
    @ColumnInfo(name = "thumbnail_name") val thumbnailName: String?,
)