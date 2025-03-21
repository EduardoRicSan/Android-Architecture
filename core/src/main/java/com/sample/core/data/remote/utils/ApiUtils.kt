package com.sample.core.data.remote.utils

import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import java.io.IOException

fun <T> safeApiCall(apiCall: suspend () -> T): Flow<NetworkResult<T>> = flow {
    emit(NetworkResult.Loading)
    try {
        val response = apiCall()
        emit(NetworkResult.Success(response))
    } catch (exception: IOException) {
        emit(NetworkResult.Error("Network error"))
    } catch (exception: ClientRequestException) {
        emit(NetworkResult.Error("Client request error"))
    } catch (exception: ServerResponseException) {
        emit(NetworkResult.Error("Server response error"))
    } catch (exception: Exception) {
        emit(NetworkResult.Error("Unknown error"))
    }
}.catch { emit(NetworkResult.Error("Unknown error")) }
    .flowOn(Dispatchers.IO)