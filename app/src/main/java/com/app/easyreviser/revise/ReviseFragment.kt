package com.app.easyreviser.revise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.app.easyreviser.R
import com.app.easyreviser.databinding.FragmentReviseBinding
import com.app.easyreviser.repository.db.AppDatabase

class ReviseFragment : Fragment() {

    lateinit var bind: FragmentReviseBinding

    val args: ReviseFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bind = FragmentReviseBinding.inflate(inflater)

        bind.flipView.setFrontText(args.daymodel.job.textFront)
        bind.root.findViewById<TextView>(R.id.cardrear)
            .setText(args.daymodel.job.textFront)

        bind.flipView.setOnFlippingListener { flipView, checked ->
            if (checked)
                bind.root.findViewById<TextView>(R.id.cardrear)
                    .setText(args.daymodel.job.textFront)
            else
                bind.flipView.setFrontText(args.daymodel.job.textBack)


        }

        bind.markasdone.setOnClickListener {
            markasDone()
        }

        if (args.daymodel.flag) {
            bind.markasdone.isEnabled = false
        }

        return bind.root
    }

    fun markasDone() {
        args.daymodel.flag = true
        AppDatabase.getInstance(requireContext()).dayDao().markCardasDone(args.daymodel)
        findNavController().popBackStack()
    }


}