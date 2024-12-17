package com.forvia.domain.di

import com.forvia.domain.api.AppApi
import com.forvia.domain.database.AppDao
import com.forvia.domain.repository.AppLocalRepository
import com.forvia.domain.repository.AppLocalRepositoryImpl
import com.forvia.domain.repository.AppRemoteRepository
import com.forvia.domain.repository.AppRemoteRepositoryImpl

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
    fun provideRemoteRepositoryModule(api: AppApi): AppRemoteRepository {
        return AppRemoteRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideLocalRepositoryModule(dao: AppDao): AppLocalRepository {
        return AppLocalRepositoryImpl(dao)
    }

}