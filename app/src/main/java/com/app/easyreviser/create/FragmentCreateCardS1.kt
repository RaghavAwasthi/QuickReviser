package com.app.easyreviser.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.easyreviser.databinding.FragCreateS1Binding

class FragmentCreateCardS1 : Fragment() {


    lateinit var binding: FragCreateS1Binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragCreateS1Binding.inflate(inflater)
        return binding.root
    }


}