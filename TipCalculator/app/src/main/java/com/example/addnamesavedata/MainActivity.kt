package com.example.addnamesavedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.addnamesavedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun calculateTip(view: View) {
        if (binding.billTotal.text.isNotEmpty()) {
            val dollarValue = binding.billTotal.text.toString().toFloat()
            var textConstruction = getString(R.string.tips_header)
            textConstruction += "\n\n"+ getString(R.string.tips_10percent)+" "+String.format("%.2f", dollarValue * 1.1)
            textConstruction += "\n"+ getString(R.string.tips_15percent)+" "+String.format("%.2f", dollarValue * 1.15)
            textConstruction += "\n"+ getString(R.string.tips_20percent)+" "+String.format("%.2f", dollarValue * 1.2)
            binding.textView.text = textConstruction
        } else {
            binding.textView.text = getString(R.string.no_value_string)
        }
    }
}