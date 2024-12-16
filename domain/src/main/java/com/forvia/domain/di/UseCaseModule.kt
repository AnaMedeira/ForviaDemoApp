package com.forvia.domain.di

import com.forvia.domain.repository.AppRepository
import com.forvia.domain.useCase.GetAppsUseCase
import com.forvia.domain.useCase.GetAppsUseCaseImpl
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
    fun provideGetAppsUseCase(repository: AppRepository): GetAppsUseCase {
        return GetAppsUseCaseImpl(repository)
    }

}