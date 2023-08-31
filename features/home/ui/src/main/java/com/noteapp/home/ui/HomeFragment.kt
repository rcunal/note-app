package com.noteapp.home.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.noteapp.core.ui.extension.collectLatestFlow
import com.noteapp.core.ui.viewBinding
import com.noteapp.home.ui.databinding.FragmentHomeBinding
import com.noteapp.home.ui.model.NoteUiModel
import com.noteapp.note_details.shared.NoteDetailsCommunicator
import com.noteapp.note_details.shared.model.NoteDetailsType
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel by viewModels<HomeViewModel>()

    @Inject
    lateinit var noteDetailsCommunicator: NoteDetailsCommunicator

    private val noteClickListener = object : NoteAdapter.NoteClickListener {
        override fun onNoteClick(noteUiModel: NoteUiModel) {
            val args = with(noteUiModel) {
                NoteDetailsCommunicator.NoteDetailsArguments(
                    noteDetailsType = NoteDetailsType.VIEW,
                    id = id,
                    createDate = createDate,
                    formattedCreateDate = formattedCreateDate,
                    modifyDate = modifyDate,
                    title = title,
                    content = content,
                    imageUrl = imageUrl,
                )
            }
            noteDetailsCommunicator.startNoteDetails(noteDetailsArguments = args)
        }

        override fun onNoteDeleteClick(noteUiModel: NoteUiModel) {
            viewModel.deleteNote(noteUiModel)
        }
    }

    private val noteAdapter = NoteAdapter(noteClickListener)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
        binding.rvHomePage.adapter = noteAdapter
        collectLatestFlow(viewModel.state, stateCollector)
    }

    private val stateCollector: suspend (HomeViewModel.UiState) -> Unit = { uiState ->
        uiState.notes?.let {
            noteAdapter.submitData(it)
        }
    }

    private fun initListeners() {
        with(binding) {
            floatingActionButton.setOnClickListener {
                noteDetailsCommunicator.startNoteDetails(
                    noteDetailsArguments = NoteDetailsCommunicator.NoteDetailsArguments(
                        noteDetailsType = NoteDetailsType.ADD
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