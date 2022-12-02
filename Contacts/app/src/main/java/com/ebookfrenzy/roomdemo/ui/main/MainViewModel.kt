package com.ebookfrenzy.roomdemo.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ebookfrenzy.roomdemo.Contact
import com.ebookfrenzy.roomdemo.ContactRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ContactRepository = ContactRepository(application)
    private val allContacts: LiveData<List<Contact>>?
    private val allContactsAsc: LiveData<List<Contact>>?
    private val allContactsDesc: LiveData<List<Contact>>?
    private val searchResults: MutableLiveData<List<Contact>>

    init {
        allContacts = repository.allContacts
        searchResults = repository.searchResults
        allContactsAsc = repository.allContactsAsc
        allContactsDesc = repository.allContactsDesc
    }

    fun insertContact(contact: Contact) {
        repository.insertContact(contact)
    }

    fun findContact(name: String) {
        repository.findContact(name)
    }

    fun deleteContact(name: String) {
        repository.deleteContact(name)
    }

    fun getSearchResults(): MutableLiveData<List<Contact>> {
        return searchResults
    }

    fun getAllContacts(): LiveData<List<Contact>>? {
        return allContacts
    }

    fun getAllContactsAsc(): LiveData<List<Contact>>? {
        return allContactsAsc
    }

    fun getAllContactsDesc(): LiveData<List<Contact>>? {
        return allContactsDesc
    }
}