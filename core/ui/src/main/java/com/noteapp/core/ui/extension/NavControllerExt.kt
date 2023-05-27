package com.noteapp.core.ui.extension

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.noteapp.core.ui.R

fun NavController.navigateWithAnimation(@IdRes resId: Int, args: Bundle?, navOptions: NavOptions? = null) {
    val navigationOptions = navOptions ?: NavOptions.Builder()
        .setEnterAnim(R.anim.slide_in_right)
        .setExitAnim(R.anim.slide_out_left)
        .setPopEnterAnim(R.anim.slide_in_left)
        .setPopExitAnim(R.anim.slide_out_right)
        .build()
    navigate(resId = resId, args = args, navOptions = navigationOptions)
}