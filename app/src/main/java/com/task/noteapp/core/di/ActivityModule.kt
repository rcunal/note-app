package com.task.noteapp.core.di

import com.noteapp.core.di.MainFragmentContainerId
import com.task.noteapp.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {

    @Provides
    @MainFragmentContainerId
    fun provideMainFragmentContainerId() = R.id.nav_host_fragment
}

