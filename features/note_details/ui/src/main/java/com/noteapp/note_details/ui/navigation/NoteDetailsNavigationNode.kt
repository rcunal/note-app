package com.noteapp.note_details.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.fragment.fragment
import androidx.navigation.navigation
import com.noteapp.core.ui.navigation.NavigationNode
import com.noteapp.note_details.ui.NoteFragment
import javax.inject.Inject

class NoteDetailsNavigationNode @Inject constructor() : NavigationNode {
    override fun addNode(navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.apply {
            navigation(startDestination = START_DESTINATION, ROUTE) {
                fragment<NoteFragment>(START_DESTINATION) {
                    label = "Note"
                }
            }
        }
    }

    companion object {
        private const val START_DESTINATION = "note_fragment"
        const val ROUTE = "note_details"
    }

}