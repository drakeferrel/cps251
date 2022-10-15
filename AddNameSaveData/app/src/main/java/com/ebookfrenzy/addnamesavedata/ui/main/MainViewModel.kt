package com.ebookfrenzy.addnamesavedata.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val rate = 0.74f
    private var nameInput = ""
    private var nameList = ""

    fun setAmount(value: String) {
        nameInput = value
        nameList += value+"\n"
    }

    fun getResult(): String {
        return nameList
    }
}