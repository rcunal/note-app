package com.noteapp.note_details.data.usecase

import com.noteapp.note_details.domain.NoteDetailsDomainModel
import com.noteapp.note_details.domain.NoteDetailsRepository
import com.noteapp.note_details.domain.usecase.SaveNoteUseCase
import java.util.Calendar
import javax.inject.Inject

class SaveNoteUseCaseImpl @Inject constructor(
    private val repository: NoteDetailsRepository
) : SaveNoteUseCase {
    override suspend fun execute(params: SaveNoteUseCase.SaveNoteParams) =
        repository.upsertNote(params.toNoteDomainModel())
}

private fun SaveNoteUseCase.SaveNoteParams.toNoteDomainModel() = run {
    val currentDate = Calendar.getInstance().time
    NoteDetailsDomainModel(
        id = noteId ?: 0,
        createDate = createDate ?: currentDate,
        modifyDate = if (isEdited) currentDate else null,
        title = title,
        content = content,
        imageUrl = imageUrl
    )
}