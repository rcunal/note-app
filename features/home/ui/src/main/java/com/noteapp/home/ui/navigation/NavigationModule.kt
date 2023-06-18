package com.noteapp.home.ui.navigation

import com.noteapp.core.ui.navigation.NavigationKey
import com.noteapp.core.ui.navigation.NavigationNode
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {
    @IntoMap
    @NavigationKey(HomeNavigationNode.ROUTE)
    @Binds
    fun bindNavigationNode(homeNavigationNode: HomeNavigationNode) : NavigationNode
}