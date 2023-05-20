package com.noteapp.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.noteapp.core.ui.extension.DEFAULT_STOP_TIMEOUT
import com.noteapp.home.domain.usecase.DeleteNoteUseCase
import com.noteapp.home.domain.usecase.GetNotesUseCase
import com.noteapp.home.ui.model.NoteUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

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