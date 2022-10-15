package com.ebookfrenzy.addnamesavedata.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val rate = 0.74f
    private var nameInput = ""
    private var nameList = "No names to display"
    private var hasInitialized = false

    fun setAmount(value: String) {
        nameInput = value

        if (!hasInitialized) {
            nameList = ""
            hasInitialized = true
        }

        nameList += value+"\n"
    }

    fun getResult(): String {
        return nameList
    }
}