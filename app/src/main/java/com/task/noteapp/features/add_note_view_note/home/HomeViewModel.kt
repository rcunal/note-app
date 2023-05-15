package com.task.noteapp.features.add_note_view_note.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.task.noteapp.core.utils.DEFAULT_STOP_TIMEOUT
import com.task.noteapp.features.add_note_view_note.common.domain.usecase.DeleteNoteUseCase
import com.task.noteapp.features.add_note_view_note.common.domain.usecase.GetNotesUseCase
import com.task.noteapp.features.add_note_view_note.home.mapper.toNoteDomainModel
import com.task.noteapp.features.add_note_view_note.home.mapper.toNoteUiModels
import com.task.noteapp.features.add_note_view_note.home.model.NoteUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject



/**
 * @author: R. Cemre Ünal,
 * created on 9/22/2022
 */

@HiltViewModel
class HomeViewModel @Inject constructor(
    getNotesUseCase: GetNotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
) : ViewModel() {

    val state = getNotesUseCase.execute()
        .cachedIn(viewModelScope)
        .map { notes ->
            UiState(notes = notes.toNoteUiModels())
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(
                stopTimeoutMillis = SharingStarted.DEFAULT_STOP_TIMEOUT
            ),
            initialValue = UiState()
        )

    fun deleteNote(noteUiModel: NoteUiModel) {
        viewModelScope.launch {
            deleteNoteUseCase.execute(noteUiModel.toNoteDomainModel())
        }
    }

    data class UiState(val notes: PagingData<NoteUiModel>? = null)
}