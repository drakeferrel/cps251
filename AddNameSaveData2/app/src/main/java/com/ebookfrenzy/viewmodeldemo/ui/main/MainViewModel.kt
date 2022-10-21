package com.ebookfrenzy.viewmodeldemo.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel : ViewModel() {

    private val rate = 0.74f
    var dollarValue: MutableLiveData<String> = MutableLiveData()
    var nameList: MutableLiveData<String> = MutableLiveData()

    fun convertValue() {
        dollarValue.let {
            if (!it.value.equals("")) {
                nameList.value += "\n"+it.value?.toFloat()?.times(rate)

            } else {
                nameList.value = "E"
            }
        }
    }
}