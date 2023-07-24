package com.noteapp.home.ui.di

import com.noteapp.home.shared.HomeCommunicator
import com.noteapp.home.ui.navigation.HomeCommunicatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
interface FragmentModule {
    @Binds
    fun bindHomeCommunicator(homeCommunicatorImpl: HomeCommunicatorImpl): HomeCommunicator
}