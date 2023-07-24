package com.noteapp.note_details.ui.navigation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.noteapp.core.di.MainFragmentContainerId
import com.noteapp.core.ui.extension.replaceFragmentAddToBackStackAnimation
import com.noteapp.note_details.shared.NoteDetailsCommunicator
import com.noteapp.note_details.ui.NoteFragment
import com.noteapp.note_details.ui.model.NoteDetailsParcelableArguments
import com.noteapp.note_details.ui.model.NoteUiModel
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class NoteDetailsCommunicatorImpl @Inject constructor(
    @MainFragmentContainerId private val mainFragmentContainerId: Int,
    @ActivityContext private val context: Context,
) : NoteDetailsCommunicator {

    private val fragmentManager = (context as AppCompatActivity).supportFragmentManager

    override fun startNoteDetails(noteDetailsArguments: NoteDetailsCommunicator.NoteDetailsArguments) {
        val fragment = NoteFragment().apply {
            arguments =
                bundleOf(NoteDetailsCommunicator.noteDetailsNavKey to noteDetailsArguments.toNoteDetailsParcelableArguments())
        }
        fragmentManager.replaceFragmentAddToBackStackAnimation(
            mainFragmentContainerId,
            fragment,
            NoteDetailsCommunicator.TAG
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