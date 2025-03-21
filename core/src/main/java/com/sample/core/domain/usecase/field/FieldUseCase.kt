package com.sample.core.domain.usecase.field

import com.sample.core.data.remote.field.model.FieldResponse
import com.sample.core.data.remote.utils.NetworkResult
import com.sample.core.domain.repository.field.FieldRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFieldUseCase @Inject constructor(
    private val repository: FieldRepository
) {
    operator fun invoke(): Flow<NetworkResult<FieldResponse>> {
        return repository.getFields()
    }
}