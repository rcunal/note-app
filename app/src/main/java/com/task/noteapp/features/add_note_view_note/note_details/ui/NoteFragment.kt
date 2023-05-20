package com.task.noteapp.features.add_note_view_note.note_details.ui

import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.task.noteapp.R
import com.noteapp.core.ui.R as CoreR
import com.noteapp.core.ui.BaseFragment
import com.noteapp.core.ui.extension.collectFlow
import com.noteapp.core.ui.extension.disable
import com.noteapp.core.ui.extension.enable
import com.noteapp.core.ui.extension.gone
import com.noteapp.core.ui.extension.loadImage
import com.noteapp.core.ui.extension.showSoftKeyboard
import com.noteapp.core.ui.extension.showToast
import com.noteapp.core.ui.extension.themeColor
import com.noteapp.core.ui.extension.visible
import com.task.noteapp.core.extension.*
import com.task.noteapp.core.utils.Constant
import com.task.noteapp.databinding.DialogAddPhotoBinding
import com.task.noteapp.databinding.DialogNoteInfoLayoutBinding
import com.task.noteapp.databinding.FragmentNoteBinding
import com.task.noteapp.features.add_note_view_note.common.domain.model.NoteDetailsType
import com.task.noteapp.features.add_note_view_note.note_details.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class NoteFragment : BaseFragment<FragmentNoteBinding>(FragmentNoteBinding::inflate) {

    private val viewModel by viewModels<NoteViewModel>()
    private val args by navArgs<NoteFragmentArgs>()

    override fun onCreateFinished() {
        if (args.noteDetailsType == NoteDetailsType.ADD) {
            binding.etTitle.showSoftKeyboard()
        }
        collectFlow(viewModel.state, stateCollector)
        collectFlow(viewModel.event, eventCollector)
    }

    private val stateCollector: suspend (NoteViewModel.UiState) -> Unit = { uiState ->
        when (uiState.currentState) {
            NoteViewModel.State.INITIAL -> viewModel.setUiState(args.noteDetailsType, args.note)
            NoteViewModel.State.VIEW_NOTE_DETAILS -> onViewNoteDetailsState(uiState)
            NoteViewModel.State.ADD_NEW_NOTE -> onAddNewNoteState(uiState.photoUrl)
            NoteViewModel.State.EDIT_NOTE -> onEditNoteState(uiState)
        }
    }

    private val eventCollector: suspend (NoteViewModel.Event) -> Unit = { event ->
        when (event) {
            NoteViewModel.Event.NoteAddedSuccessfully -> findNavController().navigateUp()
        }
    }

    private fun onViewNoteDetailsState(uiState: NoteViewModel.UiState) {
        with(binding) {
            etTitle.disable()
            etContent.disable()
            etTitle.setText(uiState.noteUiModel?.title)
            etContent.setText(uiState.noteUiModel?.content)
            ivPhoto.loadImage(uiState.photoUrl)
            ivInfo.visible()
            btnSave.gone()
            ivAddPhoto.setImageResource(R.drawable.ic_edit)

        }
    }

    private fun onAddNewNoteState(photoUrl: String?) {
        if (photoUrl.isNullOrEmpty()) {
            binding.ivPhoto.gone()
            binding.ivPhoto.setImageDrawable(null)
            binding.ivAddPhoto.setImageResource(R.drawable.ic_add_photo)
        } else {
            binding.ivPhoto.loadImage(photoUrl)
            // Couldn't find any proper drawable so we'll manually change it's color
            binding.ivAddPhoto.setImageResource(R.drawable.ic_remove_photo)
            val primaryColor = requireContext().themeColor(androidx.appcompat.R.attr.colorAccent)
            binding.ivAddPhoto.setColorFilter(
                primaryColor,
                android.graphics.PorterDuff.Mode.SRC_IN
            )
        }
    }

    private fun onEditNoteState(uiState: NoteViewModel.UiState) {
        with(binding) {
            etTitle.enable()
            etContent.enable()
            ivInfo.gone()
            btnSave.visible()

            if (uiState.photoUrl.isNullOrEmpty()) {
                ivPhoto.gone()
                ivAddPhoto.setImageResource(R.drawable.ic_add_photo)
            } else {
                ivPhoto.visible()
                ivPhoto.loadImage(uiState.photoUrl)
                ivAddPhoto.setImageResource(R.drawable.ic_remove_photo)
                val primaryColor = requireContext().themeColor(androidx.appcompat.R.attr.colorAccent)
                ivAddPhoto.setColorFilter(
                    primaryColor,
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
            }
        }
    }


    private fun showDialogForPhotoInput() {
        val dialogBinding = DialogAddPhotoBinding.inflate(LayoutInflater.from(requireContext()))
        val dialog = AlertDialog.Builder(requireContext(), CoreR.style.DarkDialog)
            .setTitle(getString(R.string.add_photo))
            .setView(dialogBinding.root)
            .setPositiveButton(getString(R.string.ok)) { _, _ ->
                viewModel.setPhoto(dialogBinding.etPhoto.text.toString())
            }
            .setNegativeButton(getString(R.string.cancel), null)
            .create()
        dialog.show()
    }

    private fun showRemovePhotoDialog() {
        val dialog = AlertDialog.Builder(
            requireContext(),
            CoreR.style.DarkDialog
        )
            .setTitle(getString(R.string.remove_photo))
            .setPositiveButton(getString(R.string.ok)) { _, _ ->
                viewModel.setPhoto(null)
            }
            .setNegativeButton(getString(R.string.cancel), null)
            .create()
        dialog.show()
    }

    override fun initListeners() {
        with(binding) {
            ivAddPhoto.setOnClickListener {
                when (viewModel.state.value.currentState) {
                    NoteViewModel.State.VIEW_NOTE_DETAILS -> viewModel.changeUiStateToEditNote()
                    NoteViewModel.State.ADD_NEW_NOTE, NoteViewModel.State.EDIT_NOTE -> {
                        if (viewModel.state.value.photoUrl.isNullOrEmpty()) {
                            showDialogForPhotoInput()
                        } else {
                            showRemovePhotoDialog()
                        }
                    }
                    else -> {}
                }
            }
            ivBack.setOnClickListener {
                findNavController().navigateUp()
            }
            btnSave.setOnClickListener {
                when {
                    etTitle.text.isNullOrEmpty() -> {
                        showToast(getString(R.string.note_title_not_entered_error))
                    }
                    etContent.text.isNullOrEmpty() -> {
                        showToast(getString(R.string.note_content_not_entered_error))
                    }
                    else -> {
                        viewModel.saveNote(etTitle.text.toString(), etContent.text.toString())
                    }
                }
            }

            ivInfo.setOnClickListener {
                val note = viewModel.state.value.noteUiModel
                val dialogBinding =
                    DialogNoteInfoLayoutBinding.inflate(LayoutInflater.from(requireContext()))
                dialogBinding.tvCreatedDateInfo.text =
                    note?.createDate?.toString(Constant.DATE_TIME_FORMAT)
                val modifyDate = note?.modifyDate
                if (modifyDate != null) {
                    dialogBinding.tvModifiedDateInfo.visible()
                    dialogBinding.tvModifiedDateInfo.text =
                        modifyDate.toString(Constant.DATE_TIME_FORMAT)
                } else {
                    dialogBinding.tvModifiedDateTitle.gone()
                    dialogBinding.tvModifiedDateInfo.gone()
                }
                val dialog = AlertDialog.Builder(requireContext(), CoreR.style.DarkDialog)
                    .setView(dialogBinding.root).create()
                dialog.show()
            }
        }
    }
}