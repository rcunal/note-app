package com.task.noteapp.features.home.ui

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @author: R. Cemre Ünal,
 * created on 9/22/2022
 */


class ItemDecoration(private val space: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        parent.layoutManager?.let {
            if (it.itemCount - 1 == parent.getChildAdapterPosition(view)) {
                outRect.bottom = space
            }
        }
    }

}