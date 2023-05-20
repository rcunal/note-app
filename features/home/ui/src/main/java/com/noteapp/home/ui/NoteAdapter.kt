package com.noteapp.home.ui

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.chauthai.swipereveallayout.ViewBinderHelper
import com.noteapp.core.ui.extension.loadImage
import com.noteapp.home.ui.databinding.ItemNoteLayoutBinding
import com.noteapp.home.ui.model.NoteUiModel

class NoteAdapter(private val noteClickListener: NoteClickListener) :
    PagingDataAdapter<NoteUiModel, NoteAdapter.ViewHolder>(COMPARATOR) {

    private val handler = Handler(Looper.getMainLooper())
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
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: NoteUiModel, newItem: NoteUiModel): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class ViewHolder(private val binding: ItemNoteLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(noteUiModel: NoteUiModel) {
            with(binding) {
                with(noteUiModel) {
                    binderHelper.bind(swipeReveal, id.toString())
                    tvTitle.text = title
                    tvContent.text = content
                    tvCreateDate.text = noteUiModel.formattedCreateDate
                    ivPhoto.loadImage(noteUiModel.imageUrl)
                    cardViewModifiedTag.isVisible = modifyDate != null
                    binding.cardViewMainContent.setOnClickListener {
                        noteClickListener.onNoteClick(
                            noteUiModel
                        )
                    }
                    binding.flDelete.setOnClickListener {
                        noteClickListener.onNoteDeleteClick(
                            noteUiModel
                        )
                    }
                }
                animateIfNeeded()
            }
        }

        private fun animateIfNeeded() {
            if (!isDeleteIconRevealed) {
                handler.postDelayed({
                    binding.swipeReveal.open(true)
                }, 1000)

                handler.postDelayed({
                    binding.swipeReveal.close(true)
                }, 2000)

                isDeleteIconRevealed = true
            }
        }
    }

    interface NoteClickListener {
        fun onNoteClick(noteUiModel: NoteUiModel)
        fun onNoteDeleteClick(noteUiModel: NoteUiModel)
    }
}