package com.noteapp.core.domain

import java.text.SimpleDateFormat
import java.util.*

fun Date.toStringWithFormat(format: String = DATE_TIME_FORMAT, locale: Locale = Locale.getDefault()): String {
    val formatter = SimpleDateFormat(format, locale)
    return formatter.format(this)
}

private const val DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm:ss"
