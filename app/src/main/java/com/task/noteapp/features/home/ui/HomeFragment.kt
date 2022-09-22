package com.task.noteapp.features.home.ui

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.task.noteapp.core.base.BaseFragment
import com.task.noteapp.core.db.Note
import com.task.noteapp.core.extension.collectFlow
import com.task.noteapp.core.extension.toPx
import com.task.noteapp.databinding.FragmentHomeBinding
import com.task.noteapp.features.add_note.domain.model.NoteDetailsType
import com.task.noteapp.features.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author: R. Cemre Ünal,
 * created on 9/21/2022
 */

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel by viewModels<HomeViewModel>()

    private val noteClickListener = object : NoteAdapter.NoteClickListener {
        override fun onNoteClick(note: Note) {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToAddNoteFragment(
                    NoteDetailsType.VIEW,
                    note
                )
            )
        }

        override fun onNoteDeleteClick(note: Note) {
            viewModel.deleteNote(note)
        }
    }

    private val noteAdapter = NoteAdapter(noteClickListener)

    override fun onCreateFinished() {

        collectFlow(viewModel.state, stateCollector)
        viewModel.getNotes()
        val decoration = ItemDecoration(80f.toPx)
        binding.rvHomePage.addItemDecoration(decoration)
        binding.rvHomePage.adapter = noteAdapter
    }

    private val stateCollector: suspend (HomeViewModel.UiState) -> Unit = { uiState ->
        uiState.notes?.let {
            noteAdapter.submitData(it)
        }
    }

    override fun initListeners() {
        with(binding) {
            floatingActionButton.setOnClickListener {
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToAddNoteFragment(
                        NoteDetailsType.ADD,
                        null
                    )
                )
            }
        }
    }
}