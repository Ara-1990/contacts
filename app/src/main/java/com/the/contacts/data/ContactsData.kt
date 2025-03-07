package com.the.contacts.data

import android.content.Context
import android.provider.ContactsContract
import androidx.lifecycle.MutableLiveData
import com.the.contacts.ui.home.Contacts

class ContactsData {


    fun contacts(context: Context, contact: MutableLiveData<MutableList<Contacts>>) {


        var contacts = mutableListOf<Contacts>()

        val projection = arrayOf(
            ContactsContract.CommonDataKinds.Phone._ID,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER,

            )

        var resolver = context.contentResolver
        resolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            projection,
            null,
            null,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC"
        )?.use { cursor ->
            val idColumn = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone._ID)
            val nameColumn =
                cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
            val numberColumn = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)

            while (cursor.moveToNext()) {
                var id = cursor.getLong(idColumn)
                var name = cursor.getString(nameColumn)
                var number = cursor.getString(numberColumn)
                contacts.add(Contacts(id, name, number))
                contact.postValue(contacts)
            }
        }

    }
}