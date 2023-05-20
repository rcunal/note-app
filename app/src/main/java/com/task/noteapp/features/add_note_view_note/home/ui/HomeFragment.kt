package com.task.noteapp.features.add_note_view_note.home.ui

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.noteapp.core.ui.BaseFragment
import com.noteapp.home.ui.NoteAdapter
import com.noteapp.core.ui.extension.collectLatestFlow
import com.task.noteapp.databinding.FragmentHomeBinding
import com.task.noteapp.features.add_note_view_note.common.domain.model.NoteDetailsType
import com.task.noteapp.features.add_note_view_note.home.HomeViewModel
import com.noteapp.home.ui.model.NoteUiModel
import dagger.hilt.android.AndroidEntryPoint


/**
 * @author: R. Cemre Ünal,
 * created on 9/21/2022
 */

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel by viewModels<HomeViewModel>()

    private val noteClickListener = object : NoteAdapter.NoteClickListener {
        override fun onNoteClick(noteUiModel: NoteUiModel) {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToAddNoteFragment(
                    NoteDetailsType.VIEW,
                    noteUiModel
                )
            )
        }

        override fun onNoteDeleteClick(noteUiModel: NoteUiModel) {
            viewModel.deleteNote(noteUiModel)
        }
    }

    private val noteAdapter = NoteAdapter(noteClickListener)

    override fun onCreateFinished() {
        binding.rvHomePage.adapter = noteAdapter
        collectLatestFlow(viewModel.state, stateCollector)
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