package com.sample.core.di.field

import com.sample.core.data.remote.field.apiservice.FieldApiService
import com.sample.core.data.remote.field.apiservice.FieldApiServiceImpl
import com.sample.core.data.remote.field.datasource.FieldDatasource
import com.sample.core.data.remote.field.datasource.FieldDatasourceImpl
import com.sample.core.data.repository.field.FieldRepositoryImpl
import com.sample.core.domain.repository.field.FieldRepository
import com.sample.core.domain.usecase.field.GetFieldUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient = HttpClient(Android) {
        install(Logging) {
            level = LogLevel.ALL
        }

        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                }
            )
        }
        defaultRequest {
            url("https://your-api.example/")
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
        }
    }

    @Provides
    fun provideFieldApiService(httpClient: HttpClient): FieldApiService {
        return FieldApiServiceImpl(httpClient)
    }

    @Provides
    fun provideFieldDataSource(apiService: FieldApiService): FieldDatasource {
        return FieldDatasourceImpl(apiService)
    }

    @Provides
    fun provideFieldRepository(dataSource: FieldDatasource): FieldRepository {
        return FieldRepositoryImpl(dataSource)
    }

    @Provides
    fun provideGetFieldUseCase(userRepository: FieldRepository): GetFieldUseCase {
        return GetFieldUseCase(userRepository)
    }
}