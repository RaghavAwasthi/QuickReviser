package com.app.easyreviser.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.app.easyreviser.databinding.FragCreateS1Binding
import com.app.easyreviser.repository.entities.CardModel

class FragmentCreateCardS1 : Fragment() {
    lateinit var parent: FragmentCreateCard

    lateinit var binding: FragCreateS1Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragCreateS1Binding.inflate(inflater)

        parentFragment?.let { fragment ->
            parent = fragment as FragmentCreateCard
            fragment.cardData.observe(viewLifecycleOwner, Observer {


            })
        }

        return binding.root
    }

    fun updateUI(data: CardModel) {

    }

    fun invokeNext(): Boolean {

        if (com.app.easyreviser.utils.TextUtils.validateFields(binding.cardtop)) {
            parent.cardData.value?.textFront = binding.cardtop.text.toString()
            return true;
        }
        return false
    }


}