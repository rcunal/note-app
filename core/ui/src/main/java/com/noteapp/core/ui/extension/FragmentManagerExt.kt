package com.noteapp.core.ui.extension

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.noteapp.core.ui.R


fun FragmentManager.addFragment(frameId: Int, fragment: Fragment, tag: String) {
    inTransaction { add(frameId, fragment, tag) }
}

fun FragmentManager.replaceFragmentAddToBackStackAnimation(
    frameId: Int,
    fragment: Fragment,
    tag: String,
): Int {
    return inTransactionWithAnimation { replace(frameId, fragment, tag).addToBackStack(tag) }
}

inline fun FragmentManager.inTransaction(operation: FragmentTransaction.() -> FragmentTransaction): Int {
    return beginTransaction().operation().commitAllowingStateLoss()
}

inline fun FragmentManager.inTransactionWithAnimation(operation: FragmentTransaction.() -> FragmentTransaction): Int {
    val transaction = beginTransaction()
        .setCustomAnimations(
            R.anim.slide_in_right,
            R.anim.slide_out_left,
            R.anim.slide_in_left,
            R.anim.slide_out_right
        )

    return transaction.operation().commitAllowingStateLoss()
}