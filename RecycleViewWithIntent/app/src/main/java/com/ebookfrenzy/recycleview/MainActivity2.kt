package com.ebookfrenzy.recycleview

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.ebookfrenzy.recycleview.databinding.ActivityMain2Binding

import com.ebookfrenzy.recycleview.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras ?: return

        val qString = extras.getString("qString")

        val tag: String? = extras.getString("tag")

        //val tag = extras.getString("tag")

        Log.i("zzz",tag.toString())

        binding.titleText.text = extras.getString("title")
        binding.detailText.text = extras.getString("detail")
        binding.imageView.setImageResource(extras.getInt("imageId"))
    }
}