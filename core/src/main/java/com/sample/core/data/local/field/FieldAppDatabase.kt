package com.sample.core.data.local.field

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FieldEntity::class], version = 1)
abstract class FieldAppDatabase : RoomDatabase() {
    abstract fun fieldDao(): FieldDao
}