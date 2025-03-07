package com.the.contacts.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.the.contacts.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    lateinit var viewModel: HomeViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        ActivityCompat.requestPermissions(requireActivity(),
            arrayOf(android.Manifest.permission.READ_CONTACTS),
            200)


        binding.rvContacts.apply {
            adapter = AdapterContacts()
            layoutManager = LinearLayoutManager(context)

        }

        viewModel.text.observe(viewLifecycleOwner) {

            (binding.rvContacts.adapter as AdapterContacts).submitList(it)
        }

        viewModel.getContact(requireContext())
        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}