package com.task.noteapp.features.add_note_view_note.note_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.noteapp.features.add_note_view_note.common.domain.model.Note
import com.task.noteapp.features.add_note_view_note.common.domain.model.NoteDetailsType
import com.task.noteapp.features.add_note_view_note.common.domain.usecase.SaveNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Calendar
import java.util.Date
import javax.inject.Inject

/**
 * @author: R. Cemre Ünal,
 * created on 9/22/2022
 */

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val saveNoteUseCase: SaveNoteUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state = _state.asStateFlow()

    private val _event = Channel<Event>(Channel.UNLIMITED)
    val event = _event.receiveAsFlow()

    fun setUiState(noteDetailsType: NoteDetailsType, note: Note?) {
        val currentState = when (noteDetailsType) {
            NoteDetailsType.ADD -> State.ADD_NEW_NOTE
            NoteDetailsType.VIEW -> State.VIEW_NOTE_DETAILS
        }
        _state.update { oldState ->
            oldState.copy(currentState = currentState, photoUrl = note?.imageUrl, note = note)
        }
    }

    fun changeUiStateToEditNote() {
        _state.update { oldState ->
            oldState.copy(currentState = State.EDIT_NOTE)
        }
    }

    fun setPhoto(photoUrl: String?) {
        _state.update { oldState ->
            oldState.copy(photoUrl = photoUrl)
        }
    }

    fun saveNote(
        title: String,
        content: String? = null,
    ) {
        viewModelScope.launch {
            state.value.run {
                var createDate: Date? = Calendar.getInstance().time
                var isEdited = false
                if (currentState == State.EDIT_NOTE) {
                    createDate = note?.createDate
                    isEdited = true

                }
                saveNoteUseCase.execute(
                    SaveNoteUseCase.SaveNoteParams(
                        noteId = note?.dbId,
                        isEdited = isEdited,
                        createDate = createDate,
                        title = title,
                        content = content,
                        imageUrl = photoUrl
                    )
                )
            }
            _event.send(Event.NoteAddedSuccessfully)
        }
    }

    sealed interface Event {
        object NoteAddedSuccessfully : Event
    }

    enum class State {
        INITIAL,
        VIEW_NOTE_DETAILS,
        ADD_NEW_NOTE,
        EDIT_NOTE
    }

    data class UiState(
        val currentState: State = State.INITIAL,
        val photoUrl: String? = null,
        val note: Note? = null
    )
}