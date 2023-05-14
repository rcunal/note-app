package com.task.noteapp.features.add_note_view_note.common.domain.usecase

import java.util.Date

interface SaveNoteUseCase {
    suspend fun execute(params: SaveNoteParams)
    data class SaveNoteParams(
        val noteId: Int?,
        val isEdited: Boolean,
        val createDate: Date?,
        val title: String,
        val content: String? = null,
        val imageUrl: String? = null,
    )
}