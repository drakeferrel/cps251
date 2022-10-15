package com.ebookfrenzy.addnamesavedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.addnamesavedata.ui.main.MainFragment
import com.ebookfrenzy.addnamesavedata.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}