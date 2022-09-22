package com.task.noteapp.core.extension

import android.view.View

/**
 * @author: R. Cemre Ünal,
 * created on 9/22/2022
 */

fun View.gone() {
    this.visibility = View.GONE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}