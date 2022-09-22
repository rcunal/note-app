package com.task.noteapp.core.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * @author: R. Cemre Ünal,
 * created on 9/22/2022
 */

fun ImageView.loadImage(url: String?) {
    url?.let {
        Glide.with(context)
            .load(url)
            .fitCenter()
            .into(this)
    }
}