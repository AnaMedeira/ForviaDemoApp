package com.forvia.domain.di

import com.forvia.domain.api.AppApi
import com.forvia.domain.repository.AppRepository
import com.forvia.domain.repository.AppRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideRepositoryModule(api: AppApi): AppRepository {
        return AppRepositoryImpl(api)
    }

}