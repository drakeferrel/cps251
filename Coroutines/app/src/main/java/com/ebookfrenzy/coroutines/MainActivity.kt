package com.ebookfrenzy.coroutines

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.view.View

import com.ebookfrenzy.coroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    private lateinit var binding: ActivityMainBinding
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        adapter = RecyclerAdapter()
        binding.recyclerView.adapter = adapter
    }

    fun launchCoroutine(view: View) {
        if (binding.nameInput.text.isNotEmpty()) {
            coroutineScope.launch(Dispatchers.Main) {
                performTask(binding.nameInput.text.toString(), (1 until 11).random().toLong()).await()
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    suspend fun performTask(name : String, delay: Long): Deferred<String> =
        coroutineScope.async(Dispatchers.Main) {
            val effectiveDelay = delay * 1000;
            delay(effectiveDelay)
            Data.names.add(binding.nameInput.text.toString())
            Data.delayAsMS.add(effectiveDelay.toString())

            // Forces a rebuild
            val refreshAdapter = binding.recyclerView.adapter
            binding.recyclerView.adapter = refreshAdapter
            return@async "Done"
        }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}