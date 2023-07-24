package com.noteapp.home.shared

interface HomeCommunicator {
    fun startHome()

    companion object {
        const val TAG = "HomeFragment"
    }
}