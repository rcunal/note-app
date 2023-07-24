package com.noteapp.note_details.shared

import com.noteapp.note_details.shared.model.NoteDetailsType
import java.util.Date

interface NoteDetailsCommunicator {
    fun startNoteDetails(noteDetailsArguments: NoteDetailsArguments)

    companion object {
        const val noteDetailsNavKey = "noteDetailsNavKey"
        const val TAG = "NoteDetailsFragment"
    }

    data class NoteDetailsArguments(
        val noteDetailsType: NoteDetailsType,
        val id: Int = 0,
        val createDate: Date? = null,
        val formattedCreateDate: String? = null,
        val modifyDate: Date? = null,
        val title: String? = null,
        val content: String? = null,
        val imageUrl: String? = null,
    )
}