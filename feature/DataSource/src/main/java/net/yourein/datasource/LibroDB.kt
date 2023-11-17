package net.yourein.datasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 1)
abstract class LibroDB: RoomDatabase() {
    companion object {
        private const val DB_NAME = "libro.db"
        @Volatile private var DB_INSTANCE: LibroDB? = null

        fun get(ctx: Context): LibroDB {
            return DB_INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    ctx,
                    LibroDB::class.java,
                    DB_NAME
                ).build()

                DB_INSTANCE = instance
                instance
            }
        }
    }
}