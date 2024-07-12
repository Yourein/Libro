package net.yourein.librocore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

val IS_PRODUCTION = booleanPreferencesKey("is_production_flag")

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "flags")