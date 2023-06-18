package com.noteapp.note_details.ui.navigation

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.noteapp.core.ui.extension.navigateWithAnimation
import com.noteapp.note_details.shared.NoteDetailsCommunicator
import com.noteapp.note_details.ui.model.NoteDetailsParcelableArguments
import com.noteapp.note_details.ui.model.NoteUiModel
import javax.inject.Inject

class NoteDetailsCommunicatorImpl @Inject constructor(private val navController: NavController) :
    NoteDetailsCommunicator {

    override fun startNoteDetails(noteDetailsArguments: NoteDetailsCommunicator.NoteDetailsArguments) {
        navController.navigateWithAnimation(
            route = NoteDetailsNavigationNode.ROUTE,
            args = bundleOf(NoteDetailsCommunicator.noteDetailsNavKey to noteDetailsArguments.toNoteDetailsParcelableArguments())
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