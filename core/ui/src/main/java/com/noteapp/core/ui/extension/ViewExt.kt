package com.noteapp.core.ui.extension

import android.view.View

/**
 * @author: R. Cemre Ünal,
 * created on 9/22/2022
 */

fun View.hide() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}