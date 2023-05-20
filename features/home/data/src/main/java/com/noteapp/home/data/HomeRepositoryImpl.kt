package com.noteapp.home.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.noteapp.core.di.IoDispatcher
import com.noteapp.datasource.local.db.NoteDao
import com.noteapp.home.domain.HomeRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val dao: NoteDao
) : HomeRepository {
    override val notes =
        Pager(
            config = PagingConfig(
                pageSize = NOTES_PAGING_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { dao.getAllNotes() }
        ).flow
            .flowOn(dispatcher)
            .map { it.toNoteDomainModels() }
}

private const val NOTES_PAGING_SIZE = 20