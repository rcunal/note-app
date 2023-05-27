package com.task.noteapp.core.di

import com.noteapp.note_details.shared.NoteDetailsCommunicator
import com.task.noteapp.communicator.NoteDetailsCommunicatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
interface FragmentModule {
    @Binds
    fun bindNoteDetailsCommunicator(noteDetailsCommunicatorImpl: NoteDetailsCommunicatorImpl): NoteDetailsCommunicator
}