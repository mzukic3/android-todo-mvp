package com.stashcoding.todoist.di

import com.stashcoding.todoist.data.network.api.ApiService
import com.stashcoding.todoist.data.repository.UserRepositoryImpl
import com.stashcoding.todoist.domain.repository.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(apiService: ApiService): UsersRepository = UserRepositoryImpl(apiService)
}
