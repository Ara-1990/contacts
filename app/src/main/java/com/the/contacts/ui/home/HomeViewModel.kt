package com.the.contacts.ui.home

import android.content.Context
import androidx.lifecycle.*
import com.the.contacts.data.ContactsData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {


    lateinit var contacts_data: ContactsData
    private val _text = MutableLiveData<MutableList<Contacts>>()
    val text: LiveData<MutableList<Contacts>> = _text

    init {
        contacts_data = ContactsData()
    }

    fun getContact(context: Context) {

        contacts_data.contacts(context, _text)
    }


}

