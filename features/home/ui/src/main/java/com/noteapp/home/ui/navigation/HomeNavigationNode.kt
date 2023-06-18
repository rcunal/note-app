package com.noteapp.home.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.fragment.fragment
import com.noteapp.core.ui.navigation.NavigationNode
import com.noteapp.home.ui.HomeFragment
import javax.inject.Inject

class HomeNavigationNode @Inject constructor() : NavigationNode {

    override fun addNode(navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.apply {
            fragment<HomeFragment>(ROUTE) {
                label = "Home"
            }
        }
    }

    companion object {
        const val ROUTE = "home"
    }
}