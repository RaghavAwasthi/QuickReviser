package com.app.easyreviser.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.app.easyreviser.databinding.FragCreateS2Binding

class FragmentCreateCardS2 : Fragment() {
    lateinit var parent: FragmentCreateCard


    lateinit var binding: FragCreateS2Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragCreateS2Binding.inflate(inflater)
        parentFragment?.let { fragment ->
            parent = fragment as FragmentCreateCard
            fragment.cardData.observe(viewLifecycleOwner, Observer {


            })
        }
        return binding.root
    }

    fun invokeNext(): Boolean {

        if (com.app.easyreviser.utils.TextUtils.validateFields(binding.cardback)) {
            parent.cardData.value?.textBack = binding.cardback.text.toString()
            return true;
        }
        return false
    }
}