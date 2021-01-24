package com.stashcoding.todoist.data.di

import com.stashcoding.todoist.data.network.api.ApiService
import com.stashcoding.todoist.data.repository.UserRepositoryImpl
import com.stashcoding.todoist.domain.repository.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideUserRepository(apiService: ApiService): UsersRepository = UserRepositoryImpl(apiService)
}
