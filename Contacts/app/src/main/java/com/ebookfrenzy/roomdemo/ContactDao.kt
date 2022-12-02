package com.ebookfrenzy.roomdemo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDao {

    @Insert
    fun insertContact(contact: Contact)

    @Query("SELECT * FROM contacts WHERE contactName LIKE '%' || :name || '%'")
    fun findContact(name: String): List<Contact>

    @Query("DELETE FROM contacts WHERE contactName = :name")
    fun deleteContact(name: String)

    @Query("SELECT * FROM contacts")
    fun getAllContacts(): LiveData<List<Contact>>

    @Query("SELECT * FROM contacts ORDER BY contactName ASC")
    fun getAllContactsAsc(): LiveData<List<Contact>>

    @Query("SELECT * FROM contacts ORDER BY contactName DESC")
    fun getAllContactsDesc(): LiveData<List<Contact>>
}