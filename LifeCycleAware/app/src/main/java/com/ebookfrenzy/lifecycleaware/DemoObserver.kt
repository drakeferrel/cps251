package com.ebookfrenzy.lifecycleaware

import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.LifecycleOwner
import com.ebookfrenzy.lifecycleaware.ui.main.MainViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DemoObserver: LifecycleObserver {
    var mv = MainViewModel

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        checkForNull()
        mv.textSum.value += "\n" + "onResume" + getTime()+showDivider()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        checkForNull()
        mv.textSum.value += "\n" + "onPause" + getTime()+showDivider()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        checkForNull()
        mv.textSum.value += "\n" + "onCreate" + getTime()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        checkForNull()
        mv.textSum.value += "\n" + "onStart" + getTime()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        checkForNull()
        mv.textSum.value += "\n" + "onStop" + getTime()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        checkForNull()
        mv.textSum.value += "\n" + "onDestroy" + getTime()+showDivider()
    }

    fun getTime(): String {
        val current = LocalDateTime.now()

        val formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")
        return " was fired on "+current.format(formatter)
    }

    fun showDivider(): String {
        return "\n*****"
    }

    fun checkForNull() {
        if (mv.textSum.value == null)
            mv.textSum.value = ""
    }
}