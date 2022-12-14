package com.ebookfrenzy.lifecycleaware.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import com.ebookfrenzy.lifecycleaware.R
import com.ebookfrenzy.lifecycleaware.DemoObserver
import com.ebookfrenzy.lifecycleaware.databinding.MainFragmentBinding
import androidx.lifecycle.Observer

class MainFragment : Fragment() {
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        lifecycle.addObserver(DemoObserver())

        val resultObserver = Observer<String> {
                result -> binding.message.text = result.toString()
        }

        viewModel.getText().observe(viewLifecycleOwner, resultObserver)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}