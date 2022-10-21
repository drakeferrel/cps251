package com.ebookfrenzy.addnamesavedata2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.addnamesavedata2.ui.main.MainFragment
import com.ebookfrenzy.addnamesavedata2.databinding.MainActivityBinding

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