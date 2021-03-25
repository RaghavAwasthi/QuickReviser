package com.app.easyreviser.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.easyreviser.databinding.FragCreateS3Binding

class FragmentCreateCardS3 : Fragment() {

    lateinit var binding: FragCreateS3Binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragCreateS3Binding.inflate(inflater)

        return binding.root
    }
}