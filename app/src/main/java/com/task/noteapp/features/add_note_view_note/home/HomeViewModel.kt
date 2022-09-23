package com.task.noteapp.features.add_note_view_note.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.task.noteapp.features.add_note_view_note.common.domain.NoteRepository
import com.task.noteapp.features.add_note_view_note.common.domain.model.Note
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
class HomeViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {

    val state = Pager(config = PagingConfig(pageSize = 20, enablePlaceholders = false),
        pagingSourceFactory = { repository.getNotes() }
    )
        .flow
        .cachedIn(viewModelScope).map { notes ->
            UiState(notes = notes.toNoteUiModels())
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5000),
            initialValue = UiState()
        )

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            repository.deleteNote(note)
        }
    }

    data class UiState(val notes: PagingData<NoteUiModel>? = null)
}