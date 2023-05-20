package com.noteapp.home.data

import com.noteapp.home.domain.GetNotesUseCase
import com.noteapp.home.domain.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface SingletonModule {
    @Binds
    @Singleton
    fun bindRepository(homeRepository: HomeRepositoryImpl): HomeRepository

    @Binds
    fun bindsGetNotesUseCase(getNotesUseCaseImpl: GetNotesUseCaseImpl): GetNotesUseCase
}