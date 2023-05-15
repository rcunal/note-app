package com.task.noteapp.features.add_note_view_note.common.data.usecase

import androidx.paging.PagingData
import com.task.noteapp.features.add_note_view_note.common.domain.model.NoteDomainModel
import com.task.noteapp.features.add_note_view_note.common.domain.repository.NoteRepository
import com.task.noteapp.features.add_note_view_note.common.domain.usecase.GetNotesUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNotesUseCaseImpl @Inject constructor(
    private val repository: NoteRepository
) : GetNotesUseCase {
    override fun execute(): Flow<PagingData<NoteDomainModel>> = repository.notes
}