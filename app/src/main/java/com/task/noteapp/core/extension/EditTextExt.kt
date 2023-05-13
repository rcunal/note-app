package com.task.noteapp.core.extension

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

/**
 * @author: R. Cemre Ünal,
 * created on 9/22/2022
 */

fun EditText.showSoftKeyboard() {
    this.requestFocus()
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

fun EditText.enable() {
    isEnabled = true
}

fun EditText.disable() {
    isEnabled = false
}