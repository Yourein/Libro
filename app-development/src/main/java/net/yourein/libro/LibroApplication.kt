package net.yourein.libro

import android.app.Application
import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.runBlocking
import net.yourein.datasource.LibroDB
import net.yourein.librocore.IS_PRODUCTION
import net.yourein.librocore.dataStore
import javax.inject.Singleton

@HiltAndroidApp
class LibroApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        runBlocking {
            applicationContext.dataStore.edit { flags ->
                flags[IS_PRODUCTION] = false
            }
        }
    }

    @Module
    @InstallIn(SingletonComponent::class)
    object LibroDBModule {

        @Singleton
        @Provides
        fun provideDB(
            @ApplicationContext context: Context,
        ) = Room.databaseBuilder(
            context = context,
            klass = LibroDB::class.java,
            name = "development_libro_db"
        ).build()

        @Singleton
        @Provides
        fun provideBookDao(db: LibroDB) = db.bookDao()
    }
}