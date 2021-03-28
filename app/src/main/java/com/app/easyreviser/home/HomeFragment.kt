package com.app.easyreviser.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.app.easyreviser.R
import com.app.easyreviser.databinding.FragHomeBinding
import com.app.easyreviser.home.adapters.CardListAdapter
import com.app.easyreviser.repository.db.AppDatabase

class HomeFragment : Fragment() {

    lateinit var binding: FragHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragHomeBinding.inflate(inflater)
        binding.addButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment2_to_fragmentCreateCard)

        }

        binding.list.layoutManager = GridLayoutManager(context, 1)
        binding.list.adapter =
            CardListAdapter(AppDatabase.getInstance(requireContext()).dayDao().getAll())

        return binding.root
    }
}