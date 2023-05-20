package com.noteapp.core.ui.extension

import kotlinx.coroutines.flow.SharingStarted

val SharingStarted.Companion.DEFAULT_STOP_TIMEOUT: Long
    get() = 5_000L