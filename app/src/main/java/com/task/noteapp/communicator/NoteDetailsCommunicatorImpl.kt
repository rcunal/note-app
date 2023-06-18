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

/**
 * Sub navgraphlar için intomap
 * createGraph in app module at runtime
 * tüm destinationlar eklendikten sonra featurelara özel navigator
 */


class NoteDetailsCommunicatorImpl @Inject constructor(private val activity: Activity) :
    NoteDetailsCommunicator {

    // Todo: provide the navController
    private val navController by lazy { activity.findNavController(R.id.nav_host_fragment) }
    override fun startNoteDetails(noteDetailsArguments: NoteDetailsCommunicator.NoteDetailsArguments) {
        navController.findDestination("note_details")?.id?.let {
            navController.navigateWithAnimation(
                it,
                bundleOf(NoteDetailsCommunicator.noteDetailsNavKey to noteDetailsArguments.toNoteDetailsParcelableArguments())
            )
        }
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