package com.task.noteapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.noteapp.home.shared.HomeCommunicator
import com.task.noteapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var homeCommunicator: HomeCommunicator

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_NoteApp)
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        homeCommunicator.startHome()
    }
}