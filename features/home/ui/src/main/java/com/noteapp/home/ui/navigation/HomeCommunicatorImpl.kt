package com.noteapp.home.ui.navigation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.noteapp.core.di.MainFragmentContainerId
import com.noteapp.core.ui.extension.addFragment
import com.noteapp.home.shared.HomeCommunicator
import com.noteapp.home.ui.HomeFragment
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class HomeCommunicatorImpl @Inject constructor(
    @MainFragmentContainerId private val mainFragmentContainerId: Int,
    @ActivityContext private val context: Context,
) : HomeCommunicator {

    private val fragmentManager = (context as AppCompatActivity).supportFragmentManager

    override fun startHome() {
        val fragment = HomeFragment()
        fragmentManager.addFragment(mainFragmentContainerId, fragment, HomeCommunicator.TAG)
    }
}