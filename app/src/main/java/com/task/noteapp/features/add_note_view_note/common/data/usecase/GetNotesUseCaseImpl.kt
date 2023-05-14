package com.task.noteapp.features.add_note_view_note.common.data.usecase

import androidx.paging.PagingSource
import com.task.noteapp.features.add_note_view_note.common.domain.model.Note
import com.task.noteapp.features.add_note_view_note.common.domain.repository.NoteRepository
import com.task.noteapp.features.add_note_view_note.common.domain.usecase.GetNotesUseCase
import javax.inject.Inject

class GetNotesUseCaseImpl @Inject constructor(
    private val repository: NoteRepository
) : GetNotesUseCase {
    override fun execute(): PagingSource<Int, Note> = repository.getNotes()
}