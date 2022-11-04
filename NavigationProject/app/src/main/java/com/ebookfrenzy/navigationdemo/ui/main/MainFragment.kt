package com.ebookfrenzy.navigationdemo.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ebookfrenzy.navigationdemo.R
import androidx.navigation.Navigation

import com.ebookfrenzy.navigationdemo.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.displayImage1.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond()

            action.message = getString(R.string.title_image1)
            action.image = R.drawable.android_image_1.toString()
            Navigation.findNavController(it).navigate(action)
        }

        binding.displayImage2.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond()
            action.message = getString(R.string.title_image2)
            action.image = R.drawable.android_image_2.toString()
            Navigation.findNavController(it).navigate(action)
        }

        binding.displayImage3.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond()
            action.message = getString(R.string.title_image3)
            action.image = R.drawable.android_image_3.toString()
            Navigation.findNavController(it).navigate(action)
        }
    }

}