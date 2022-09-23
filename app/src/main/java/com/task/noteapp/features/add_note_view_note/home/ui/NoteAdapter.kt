package com.task.noteapp.features.add_note_view_note.home.ui

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.chauthai.swipereveallayout.ViewBinderHelper
import com.task.noteapp.features.add_note_view_note.common.domain.model.Note
import com.task.noteapp.databinding.ItemNoteLayoutBinding
import com.task.noteapp.features.add_note_view_note.home.model.NoteUiModel

/**
 * @author: R. Cemre Ünal,
 * created on 9/22/2022
 */
class NoteAdapter(private val noteClickListener: NoteClickListener) :
    PagingDataAdapter<NoteUiModel, NoteAdapter.ViewHolder>(COMPARATOR) {

    private val binderHelper = ViewBinderHelper().apply { setOpenOnlyOne(true) }
    private var isDeleteIconRevealed = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemNoteLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { note ->
            holder.bind(note)
        }
    }

    companion object {
        val COMPARATOR = object : DiffUtil.ItemCallback<NoteUiModel>() {
            override fun areItemsTheSame(oldItem: NoteUiModel, newItem: NoteUiModel): Boolean {
                return oldItem.note.dbId == newItem.note.dbId
            }

            override fun areContentsTheSame(oldItem: NoteUiModel, newItem: NoteUiModel): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class ViewHolder(val binding: ItemNoteLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(noteUiModel: NoteUiModel) {
            with(noteUiModel.note) {
                binderHelper.bind(binding.swipeReveal, dbId.toString())
                binding.noteUiModel = noteUiModel
                binding.cardViewMainContent.setOnClickListener { noteClickListener.onNoteClick(this) }
                binding.flDelete.setOnClickListener { noteClickListener.onNoteDeleteClick(this) }

                if (!isDeleteIconRevealed) {
                    Handler(Looper.getMainLooper()).postDelayed({
                        binding.swipeReveal.open(true)
                    }, 1000)

                    Handler(Looper.getMainLooper()).postDelayed({
                        binding.swipeReveal.close(true)
                    }, 2000)

                    isDeleteIconRevealed = true
                }
            }
        }

    }

    interface NoteClickListener {
        fun onNoteClick(note: Note)
        fun onNoteDeleteClick(note: Note)
    }
}