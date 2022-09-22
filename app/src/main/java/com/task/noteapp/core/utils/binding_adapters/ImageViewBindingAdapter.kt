package com.task.noteapp.core.utils.binding_adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.task.noteapp.core.extension.loadImage

/**
 * @author: R. Cemre Ünal,
 * created on 9/22/2022
 */

@BindingAdapter("bind:load")
fun loadImage(imageView: ImageView, url: String?) {
    imageView.loadImage(url)
}