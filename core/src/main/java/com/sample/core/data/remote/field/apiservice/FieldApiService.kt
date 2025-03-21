package com.sample.core.data.remote.field.apiservice

import com.sample.core.data.remote.field.model.FieldDTO
import com.sample.core.data.remote.field.model.FieldResponse
import com.sample.core.domain.model.field.Field
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.client.request.get
import javax.inject.Inject

interface FieldApiService {
    suspend fun getFields(): FieldResponse
}

class FieldApiServiceImpl @Inject constructor(private val httpClient: HttpClient) : FieldApiService {

    override suspend fun getFields(): FieldResponse {
        val response = httpClient.get("https://api.example.com/") {
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
        }
        return response.body()
    }
}