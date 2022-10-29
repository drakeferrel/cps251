package com.ebookfrenzy.lifecycleaware.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    companion object {
        var textSum: MutableLiveData<String> = MutableLiveData()
    }

    fun getText(): MutableLiveData<String> {
        return textSum;
    }
}