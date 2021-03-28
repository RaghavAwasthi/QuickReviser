package com.app.easyreviser.create

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.app.easyreviser.R
import com.app.easyreviser.databinding.FragCreateS3Binding

class FragmentCreateCardS3 : Fragment(), View.OnClickListener {
    lateinit var parent: FragmentCreateCard

    lateinit var binding: FragCreateS3Binding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragCreateS3Binding.inflate(inflater)
        attachListeners(
            binding.dayview.Fr,
            binding.dayview.Su, binding.dayview.M, binding.dayview.Tu, binding.dayview.We,
            binding.dayview.Th, binding.dayview.Sa
        )
        parentFragment?.let { fragment ->
            parent = fragment as FragmentCreateCard
            fragment.cardData.observe(viewLifecycleOwner, Observer {


            })
        }
        return binding.root
    }

    private fun attachListeners(vararg views: TextView) {
        views.forEach {
            it.setOnClickListener(this)
        }
    }

    fun invokeNext(): Boolean {

        if (com.app.easyreviser.utils.TextUtils.validateFields(
                binding.shortDesc,
            )
        ) {
            parent.cardData.value?.shortdesctiption = binding.shortDesc.text.toString()
            parent.cardData.value?.priority = binding.priority.selectedItemPosition
            parent.cardData.value?.repeatFrequency = generateArray(
                binding.dayview.Fr,
                binding.dayview.Su, binding.dayview.M, binding.dayview.Tu, binding.dayview.We,
                binding.dayview.Th, binding.dayview.Sa
            )

            return true;
        }
        return false
    }

    override fun onClick(v: View) {
        if (v.tag != "E") {
            v.tag = "E"
            (v as TextView).setTextColor(Color.parseColor("#FFFFFF"))
            (v as TextView).background =
                ContextCompat.getDrawable(requireContext(), R.drawable.dayview_selected)
        } else {
            v.tag = null
            (v as TextView).setTextColor(Color.parseColor("#000000"))
            (v as TextView).background =
                ContextCompat.getDrawable(requireContext(), R.drawable.bg_dayview_unselected)

        }

    }

    fun generateArray(vararg args: TextView): ArrayList<Int> {
        var array = ArrayList<Int>()
        args.forEach {
            if (it.tag == "E")
                array.add(1)
            else
                array.add(0)
        }
        return array
    }
}