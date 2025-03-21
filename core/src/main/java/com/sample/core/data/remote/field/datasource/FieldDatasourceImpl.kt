package com.sample.core.data.remote.field.datasource

import com.sample.core.data.remote.field.apiservice.FieldApiService
import com.sample.core.data.remote.field.model.FieldResponse
import com.sample.core.data.remote.utils.NetworkResult
import com.sample.core.data.remote.utils.safeApiCall
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FieldDatasourceImpl @Inject constructor(
    private val apiService: FieldApiService
) : FieldDatasource {

    override fun getFields(): Flow<NetworkResult<FieldResponse>> = safeApiCall {
        apiService.getFields()
    }

}