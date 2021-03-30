package com.app.easyreviser.create

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.app.easyreviser.R
import com.app.easyreviser.databinding.FragCreateCardBinding
import com.app.easyreviser.repository.AppRepository
import com.app.easyreviser.repository.entities.CardModel
import com.app.easyreviser.utils.AppUtils.setImageDrawableWithAnimation

class FragmentCreateCard : Fragment() {

    var cardData = MutableLiveData(CardModel())

    lateinit var bind: FragCreateCardBinding
    var curr = 1;

    lateinit var currentFrag: Fragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragCreateCardBinding.inflate(inflater)
        setCurrentFragm(FragmentCreateCardS1())
        bind.next.setOnClickListener {

            processNext()
        }

        activity?.setTitle("Create Card")


        return bind.rootview
    }

    fun saveData() {

        cardData.value?.let {
            AppRepository.getInstance(requireContext()).addCard(it)
        }
        findNavController().popBackStack()



        Log.d("TAG", "saveData: ${cardData.value}")
    }


    fun updateUI() {


    }

    fun processNext() {
        when (curr) {

            1 -> {
                if (currentFrag is FragmentCreateCardS1)
                    if ((currentFrag as FragmentCreateCardS1).invokeNext()) {
                        curr++;
                        setCurrentFragm(FragmentCreateCardS2())
                        updateUI()
                        bind.header.topViewImage.setImageDrawableWithAnimation(
                            ResourcesCompat.getDrawable(
                                resources,
                                R.drawable.ic_stepper_1,
                                requireActivity().theme!!
                            )!!, 1000
                        )
                        bind.header.backViewImage.setImageResource(R.drawable.ic_stepper_2_numeric_pre)


                    }
            }

            2 -> {
                if (currentFrag is FragmentCreateCardS2)
                    if ((currentFrag as FragmentCreateCardS2).invokeNext()) {
                        curr++;
                        setCurrentFragm(FragmentCreateCardS3())
                        updateUI()
                        bind.header.backViewImage.setImageResource(R.drawable.ic_stepper_1)
                        bind.header.AdditionalImage.setImageResource(R.drawable.ic_stepper_3_numeric_pre)


                    }
            }
            3 -> {
                if (currentFrag is FragmentCreateCardS3)
                    if ((currentFrag as FragmentCreateCardS3).invokeNext()) {
                        saveData()
                        updateUI()
                    }
            }
        }
    }

    fun setCurrentFragm(frag: Fragment) {
        currentFrag = frag;
        childFragmentManager.beginTransaction().replace(R.id.fragment, frag)
            .commit();
    }


}