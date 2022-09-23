package com.task.noteapp.utils

import android.graphics.Bitmap
import androidx.test.platform.app.InstrumentationRegistry
import com.bumptech.glide.Glide

/**
 * @author: R. Cemre Ünal,
 * created on 9/23/2022
 */
object Utils {
    fun getBitmapFromUrl(url: String): Bitmap {
        return Glide.with(InstrumentationRegistry.getInstrumentation().targetContext)
            .asBitmap()
            .load(url)
            .submit()
            .get()
    }
}
