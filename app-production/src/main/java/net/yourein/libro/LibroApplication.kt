package net.yourein.libro

import android.app.Application
import androidx.datastore.preferences.core.edit
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.runBlocking
import net.yourein.librocore.IS_PRODUCTION
import net.yourein.librocore.dataStore

@HiltAndroidApp
class LibroApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        runBlocking {
            applicationContext.dataStore.edit { flags ->
                flags[IS_PRODUCTION] = true
            }
        }
    }
}