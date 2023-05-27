package com.noteapp.note_details.ui.model

import android.os.Parcelable
import com.noteapp.note_details.shared.model.NoteDetailsType
import kotlinx.parcelize.Parcelize

@Parcelize
data class NoteDetailsParcelableArguments(
    val noteDetailsType: NoteDetailsType,
    val noteUiModel: NoteUiModel? = null,
) : Parcelable
