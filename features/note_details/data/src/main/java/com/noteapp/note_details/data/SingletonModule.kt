package com.noteapp.note_details.data

import com.noteapp.note_details.data.usecase.DeleteNoteUseCaseImpl
import com.noteapp.note_details.data.usecase.SaveNoteUseCaseImpl
import com.noteapp.note_details.domain.NoteDetailsRepository
import com.noteapp.note_details.domain.usecase.DeleteNoteUseCase
import com.noteapp.note_details.domain.usecase.SaveNoteUseCase
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
    fun bindRepository(noteDetailsRepositoryImpl: NoteDetailsRepositoryImpl): NoteDetailsRepository

    @Binds
    fun bindsSaveNoteUseCase(saveNoteUseCaseImpl: SaveNoteUseCaseImpl): SaveNoteUseCase

    @Binds
    fun bindsDeleteNoteUseCase(deleteNoteUseCaseImpl: DeleteNoteUseCaseImpl): DeleteNoteUseCase
}