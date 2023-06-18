package com.noteapp.note_details.ui.di

import com.noteapp.note_details.shared.NoteDetailsCommunicator
import com.noteapp.note_details.ui.navigation.NoteDetailsCommunicatorImpl
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