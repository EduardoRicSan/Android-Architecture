package com.sample.core.data.remote.field.datasource

import com.sample.core.data.remote.field.model.FieldResponse
import com.sample.core.data.remote.utils.NetworkResult
import com.sample.core.domain.model.field.Field
import kotlinx.coroutines.flow.Flow

interface FieldDatasource {
    fun getFields(): Flow<NetworkResult<FieldResponse>>
}