package com.task.noteapp.core.extension

import java.text.SimpleDateFormat
import java.util.*

/**
 * @author: R. Cemre Ünal,
 * created on 9/22/2022
 */

fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
    val formatter = SimpleDateFormat(format, locale)
    return formatter.format(this)
}