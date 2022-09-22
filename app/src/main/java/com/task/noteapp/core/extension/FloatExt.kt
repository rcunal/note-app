package com.task.noteapp.core.extension

import android.content.res.Resources

/**
 * @author: R. Cemre Ünal,
 * created on 9/22/2022
 */

val Float.toPx get() = (this * Resources.getSystem().displayMetrics.density).toInt()
