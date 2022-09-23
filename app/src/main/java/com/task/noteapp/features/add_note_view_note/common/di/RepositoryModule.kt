package com.task.noteapp.features.add_note_view_note.common.di

import com.task.noteapp.features.add_note_view_note.common.data.NoteRepositoryImpl
import com.task.noteapp.features.add_note_view_note.common.domain.NoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author: R. Cemre Ünal,
 * created on 9/22/2022
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRepository(noteRepositoryImpl: NoteRepositoryImpl): NoteRepository
}