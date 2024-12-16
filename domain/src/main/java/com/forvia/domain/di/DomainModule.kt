package com.forvia.domain.di

import com.forvia.domain.api.AppApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) //Singleton of retrofit
object DomainModule {
    val BASE_URL = "https://ws2.aptoide.com/"
    val withUnknownKeys =
        Json { ignoreUnknownKeys = true }.asConverterFactory("application/json".toMediaType())


    @Provides
    @Singleton
    fun provideRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(withUnknownKeys)
        .build()

    @Provides
    @Singleton
    fun provideAppApi(retrofit: Retrofit): AppApi = retrofit.create(AppApi::class.java)


}