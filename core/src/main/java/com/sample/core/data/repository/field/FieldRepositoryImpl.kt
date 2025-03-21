package com.sample.core.data.repository.field

import com.sample.core.data.remote.field.datasource.FieldDatasource
import com.sample.core.data.remote.field.model.FieldResponse
import com.sample.core.data.remote.utils.NetworkResult
import com.sample.core.domain.repository.field.FieldRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FieldRepositoryImpl @Inject constructor(private val dataSource: FieldDatasource) : FieldRepository {

    override fun getFields(): Flow<NetworkResult<FieldResponse>> = dataSource.getFields()
}