package com.ebookfrenzy.addnamesavedata2.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel : ViewModel() {
    var nameInput: MutableLiveData<String> = MutableLiveData()
    var nameList: MutableLiveData<String> = MutableLiveData("No names to display")
    var hasInitialized: MutableLiveData<Boolean> = MutableLiveData(false)

    fun addName() {
        nameInput.let {
            if (!it.value.equals("")) {
                if (hasInitialized.value == true) {
                    nameList.value += it.value.toString() + "\n"
                } else {
                    nameList.value = it.value.toString() + "\n"
                    hasInitialized.value = true;
                }
            }
        }
    }
}