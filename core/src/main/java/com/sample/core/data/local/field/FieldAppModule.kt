package com.sample.core.data.local.field

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FieldAppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): FieldAppDatabase =
        Room.databaseBuilder(
            context,
            FieldAppDatabase::class.java,
            "field_database",
        )
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideFieldDao(database: FieldAppDatabase): FieldDao {
        return database.fieldDao()
    }
}