package com.the.contacts.ui.home

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.the.contacts.R

class AdapterContacts () : RecyclerView.Adapter<AdapterContacts.ContactsViewHolder>() {


    private var contactsList = mutableListOf<Contacts>()



    fun submitList(contactsList: List<Contacts>) {
        this.contactsList.addAll(contactsList)

    }


    inner class ContactsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var tv_name = view.findViewById<TextView>(R.id.tv_name)
        var tv_contacts = view.findViewById<TextView>(R.id.tv_contacts)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contacts, parent, false)
        return ContactsViewHolder(view)

    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {

        var list = contactsList[position]


        holder.tv_name.text = list.name
        holder.tv_contacts.text = list.number



    }

    override fun getItemCount(): Int {

        return contactsList.size

    }

}