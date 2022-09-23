package com.task.noteapp.features.add_note_view_note.home.ui

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.task.noteapp.core.base.BaseFragment
import com.task.noteapp.features.add_note_view_note.common.domain.model.Note
import com.task.noteapp.core.extension.collectLatestFlow
import com.task.noteapp.databinding.FragmentHomeBinding
import com.task.noteapp.features.add_note_view_note.common.domain.model.NoteDetailsType
import com.task.noteapp.features.add_note_view_note.home.HomeViewModel
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

        collectLatestFlow(viewModel.state, stateCollector)
//        viewModel.getNotes()
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

            rvHomePage.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    if (dy < 0 && !floatingActionButton.isShown)
                        floatingActionButton.show()
                    else if (dy > 0 && floatingActionButton.isShown)
                        floatingActionButton.hide()
                }
            })
        }
    }
}