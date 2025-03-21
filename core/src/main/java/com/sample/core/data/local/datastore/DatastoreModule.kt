package com.sample.core.data.local.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.io.File
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
        // Aquí especificamos el nombre del archivo y lo creamos con PreferenceDataStoreFactory
        val dataStoreFile = File(context.filesDir, "fields_preferences")
        return PreferenceDataStoreFactory.create(
            produceFile = { dataStoreFile }
        )
    }
}