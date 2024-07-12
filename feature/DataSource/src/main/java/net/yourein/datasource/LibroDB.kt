package net.yourein.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import net.yourein.datasource.daos.BookDao
import net.yourein.datasource.entities.Book
import net.yourein.datasource.entities.BookTag
import net.yourein.datasource.entities.Series
import net.yourein.datasource.entities.SeriesBook
import net.yourein.datasource.entities.Tag

@Database(
    entities = [
        Book::class,
        Tag::class, BookTag::class,
        Series::class, SeriesBook::class,
        ],
    version = 1)
abstract class LibroDB: RoomDatabase() {
    abstract fun bookDao(): BookDao

//    companion object {
//        private const val DB_NAME = "libro.db"
//        @Volatile private var DB_INSTANCE: LibroDB? = null
//
//        fun get(ctx: Context): LibroDB {
//            return DB_INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    ctx,
//                    LibroDB::class.java,
//                    DB_NAME
//                ).build()
//
//                DB_INSTANCE = instance
//                instance
//            }
//        }
//    }
}