package com.task.noteapp.features.add_note_view_note.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.task.noteapp.features.add_note_view_note.common.domain.model.Note
import com.task.noteapp.features.add_note_view_note.common.domain.NoteRepository
import com.task.noteapp.features.add_note_view_note.home.mapper.toNoteUiModels
import com.task.noteapp.features.add_note_view_note.home.model.NoteUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author: R. Cemre Ünal,
 * created on 9/22/2022
 */

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state = _state.asStateFlow()

    init {
        getNotes()
    }

    private fun getNotes() {
        viewModelScope.launch {
            repository.getNotes().cachedIn(viewModelScope).collect { notes ->
                _state.update { oldState ->
                    oldState.copy(notes = notes.toNoteUiModels())
                }
            }
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            repository.deleteNote(note)

            repository.getNotes().collect { notes ->
                _state.update { oldState ->
                    oldState.copy(notes = notes.toNoteUiModels())
                }
            }
        }
    }

    data class UiState(val notes: PagingData<NoteUiModel>? = null)
}