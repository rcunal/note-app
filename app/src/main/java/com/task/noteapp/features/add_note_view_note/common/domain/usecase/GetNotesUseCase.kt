package com.task.noteapp.features.add_note_view_note.common.domain.usecase

import androidx.paging.PagingSource
import com.task.noteapp.features.add_note_view_note.common.domain.model.Note

interface GetNotesUseCase {
    fun execute(): PagingSource<Int, Note>
}