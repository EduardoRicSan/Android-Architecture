package com.sample.core.domain.repository.field

import com.sample.core.data.remote.field.model.FieldResponse
import com.sample.core.data.remote.utils.NetworkResult
import kotlinx.coroutines.flow.Flow

interface FieldRepository {
    fun getFields(): Flow<NetworkResult<FieldResponse>>
}