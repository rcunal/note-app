package com.task.noteapp.core.utils.binding_adapters

import android.view.View
import androidx.databinding.BindingAdapter
import com.task.noteapp.core.extension.gone
import com.task.noteapp.core.extension.visible

/**
 * @author: R. Cemre Ünal,
 * created on 9/22/2022
 */

@BindingAdapter("bind:make_visible_if_exist")
fun setVisibility(view: View, obj: Any?) {
    when {
        obj == null || (obj is String && obj.isEmpty()) -> view.gone()
        else -> view.visible()
    }
}