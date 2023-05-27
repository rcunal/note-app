package com.task.noteapp.communicator

import android.app.Activity
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.noteapp.core.ui.extension.navigateWithAnimation
import com.noteapp.note_details.shared.NoteDetailsCommunicator
import com.noteapp.note_details.ui.model.NoteDetailsParcelableArguments
import com.noteapp.note_details.ui.model.NoteUiModel
import com.task.noteapp.R
import javax.inject.Inject

class NoteDetailsCommunicatorImpl @Inject constructor(private val activity: Activity) :
    NoteDetailsCommunicator {
    override fun startNoteDetails(noteDetailsArguments: NoteDetailsCommunicator.NoteDetailsArguments) {
        activity.findNavController(R.id.nav_host_fragment).navigateWithAnimation(
            R.id.note_details_fragment,
            bundleOf(NoteDetailsCommunicator.noteDetailsNavKey to noteDetailsArguments.toNoteDetailsParcelableArguments()),
        )
    }

    private fun NoteDetailsCommunicator.NoteDetailsArguments.toNoteDetailsParcelableArguments(): NoteDetailsParcelableArguments {
        val noteUiModel = runCatching {
            NoteUiModel(
                id = id,
                createDate = requireNotNull(createDate),
                formattedCreateDate = requireNotNull(formattedCreateDate),
                modifyDate = modifyDate,
                title = requireNotNull(title),
                content = content,
                imageUrl = imageUrl
            )
        }.getOrNull()
        return NoteDetailsParcelableArguments(
            noteUiModel = noteUiModel,
            noteDetailsType = noteDetailsType
        )
    }
}