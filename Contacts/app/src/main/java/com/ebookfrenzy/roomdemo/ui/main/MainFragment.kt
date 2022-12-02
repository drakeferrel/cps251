package com.ebookfrenzy.roomdemo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ebookfrenzy.roomdemo.Contact
import com.ebookfrenzy.roomdemo.R
import com.ebookfrenzy.roomdemo.databinding.MainFragmentBinding


class MainFragment : Fragment(), ContactListAdapter.OnTextClickListener {

    private var adapter: ContactListAdapter? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    val viewModel: MainViewModel by viewModels()
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)

        listenerSetup()
        observerSetup()
        recyclerSetup()

        return binding.root
    }

    private fun listenerSetup() {

        binding.addButton.setOnClickListener {
            val contactName = binding.contactName.text.toString()
            val phoneNumber = binding.contactNumber.text.toString()

            if (contactName != "" && phoneNumber != "") {
                val product = Contact(contactName, phoneNumber)
                viewModel.insertContact(product)
                clearFields()
            } else {
                Toast.makeText(context, R.string.add_error, 3).show()
            }
        }

        binding.findButton.setOnClickListener {
            viewModel.findContact(binding.contactName.text.toString())
        }

        binding.ascButton.setOnClickListener {
            viewModel.getAllContactsAsc()?.observe(viewLifecycleOwner, Observer { contacts ->
                contacts?.let  {
                    adapter?.setProductList(it)
                }
            })
        }

        binding.descButton.setOnClickListener {
            viewModel.getAllContactsDesc()?.observe(viewLifecycleOwner, Observer { contacts ->
                contacts?.let  {
                    adapter?.setProductList(it)
                }
            })
        }
    }

    private fun observerSetup() {

        viewModel.getAllContacts()?.observe(viewLifecycleOwner, Observer { contacts ->
            contacts?.let  {
                adapter?.setProductList(it)
            }
        })

        viewModel.getSearchResults().observe(viewLifecycleOwner, Observer { contacts ->
            contacts?.let {
                if (it.isNotEmpty()) {
                    adapter?.setProductList(it);
                } else {
                    Toast.makeText(context, R.string.find_error, 3).show()
                }
            }
        })
    }

    override fun onTextClick(data: String) {
        // Now you can do however you want with the data here...
        println("Clicked "+data)
        viewModel.deleteContact(data)
    }

    private fun recyclerSetup() {
        adapter = ContactListAdapter(R.layout.product_list_item, this)
        binding.productRecycler.layoutManager = LinearLayoutManager(context)
        binding.productRecycler.adapter = adapter
    }

    private fun clearFields() {
        // binding.productID.text = ""
        binding.contactName.setText("")
        binding.contactNumber.setText("")
    }
}