package com.sample.core.data.local.field

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FieldDao {
    @Insert
    suspend fun insert(fieldEntity: FieldEntity)

    @Query("SELECT * FROM fields")
    fun getFields(): Flow<List<FieldEntity>>
}