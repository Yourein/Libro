package net.yourein.libro

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class LibroApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // これ絶対いらない
    }
}