package com.task.noteapp.core.utils

import kotlinx.coroutines.flow.SharingStarted

/**
 * @author: R. Cemre Ünal,
 * created on 9/21/2022
 */
object Constant {
    const val DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm:ss"
    const val DATE_FORMAT = "dd/MM/yyyy"
}

val SharingStarted.Companion.DEFAULT_STOP_TIMEOUT: Long
    get() = 5_000L