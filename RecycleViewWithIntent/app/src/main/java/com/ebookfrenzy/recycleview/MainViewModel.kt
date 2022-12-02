package com.ebookfrenzy.recycleview
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    companion object {
        val randomizedTitle = arrayOf(
            (0 until Data.titles.size).random(),
            (0 until Data.titles.size).random(),
            (0 until Data.titles.size).random(),
            (0 until Data.titles.size).random(),
            (0 until Data.titles.size).random(),
            (0 until Data.titles.size).random(),
            (0 until Data.titles.size).random(),
            (0 until Data.titles.size).random(),
        )

        val randomizedDetail = arrayOf(
            (0 until Data.titles.size).random(),
            (0 until Data.titles.size).random(),
            (0 until Data.titles.size).random(),
            (0 until Data.titles.size).random(),
            (0 until Data.titles.size).random(),
            (0 until Data.titles.size).random(),
            (0 until Data.titles.size).random(),
            (0 until Data.titles.size).random(),
        )

        val randomizedImageId = arrayOf(
            (0 until Data.titles.size).random(),
            (0 until Data.titles.size).random(),
            (0 until Data.titles.size).random(),
            (0 until Data.titles.size).random(),
            (0 until Data.titles.size).random(),
            (0 until Data.titles.size).random(),
            (0 until Data.titles.size).random(),
            (0 until Data.titles.size).random(),
        )
    }
}