package com.noteapp.core.ui.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * @author: R. Cemre Ünal,
 * created on 9/22/2022
 */

fun ImageView.loadImage(url: String?) {
    if (url.isNullOrEmpty()) gone()
    else {
        Glide.with(context)
            .load(url)
            .fitCenter()
            .into(this)
    }
}