package com.task.noteapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.createGraph
import androidx.navigation.fragment.NavHostFragment
import com.noteapp.core.ui.navigation.NavigationNode
import com.noteapp.home.ui.navigation.HomeNavigationNode
import com.task.noteapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigationNodes: @JvmSuppressWildcards Map<String, NavigationNode>

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_NoteApp)
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupNavGraph()
    }

    private fun setupNavGraph() {
        val navController =
            (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController

        navController.graph = navController.createGraph(
            startDestination = HomeNavigationNode.ROUTE
        ) {
            navigationNodes.forEach { entry ->
                val navNode = entry.value
                navNode.addNode(this)
            }
        }
    }
}