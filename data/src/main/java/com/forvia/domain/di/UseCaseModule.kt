package com.forvia.domain.di

import com.forvia.domain.repository.AppLocalRepository
import com.forvia.domain.repository.AppRemoteRepository
import com.forvia.domain.useCase.GetAppsUseCase
import com.forvia.domain.useCase.GetAppsUseCaseImpl
import com.forvia.domain.useCase.GetLocalAppsUseCase
import com.forvia.domain.useCase.GetLocalAppsUseCaseImpl
import com.forvia.domain.useCase.GetRemoteAppsUseCase
import com.forvia.domain.useCase.GetRemoteAppsUseCaseImpl
import com.forvia.domain.useCase.SaveLocalAppsUseCase
import com.forvia.domain.useCase.SaveLocalAppsUseCaseImpl
import com.forvia.domain.utils.NetworkUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideGetRemoteAppsUseCase(repository: AppRemoteRepository): GetRemoteAppsUseCase {
        return GetRemoteAppsUseCaseImpl(repository)
    }

    @Provides
    @Singleton
    fun provideGetLocalAppsUseCase(repository: AppLocalRepository): GetLocalAppsUseCase {
        return GetLocalAppsUseCaseImpl(repository)
    }

    @Provides
    @Singleton
    fun provideSaveLocalAppsUseCase(repository: AppLocalRepository): SaveLocalAppsUseCase {
        return SaveLocalAppsUseCaseImpl(repository)
    }

    @Provides
    @Singleton
    fun provideGetAppsUseCase(
        networkUtils: NetworkUtils,
        remoteAppsUseCase: GetRemoteAppsUseCase,
        localAppsUseCase: GetLocalAppsUseCase,
        saveLocalAppsUseCase: SaveLocalAppsUseCase
    ): GetAppsUseCase {
        return GetAppsUseCaseImpl(
            networkUtils,
            remoteAppsUseCase,
            localAppsUseCase,
            saveLocalAppsUseCase
        )
    }

}