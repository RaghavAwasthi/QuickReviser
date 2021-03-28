package com.app.easyreviser.create

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.app.easyreviser.R
import com.app.easyreviser.databinding.FragCreateCardBinding
import com.app.easyreviser.repository.db.AppDatabase
import com.app.easyreviser.repository.entities.CardModel
import com.app.easyreviser.repository.entities.DayModel

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
            AppDatabase.getInstance(requireContext()).userDao().insertAll(it)
            addCard(it)
        }
        findNavController().popBackStack()



        Log.d("TAG", "saveData: ${cardData.value}")
    }

    fun addCard(card: CardModel) {
        var count = 0;
        var arrayofdayCodes = arrayListOf<String>("Su", "Mo", "Tu", "We", "Th", "Fr", "Sa")
        for (i in card.repeatFrequency) {
            if (i == 1)
                AppDatabase.getInstance(requireContext()).dayDao().insertAll(
                    DayModel(
                        job = card,
                        code = arrayofdayCodes.get(count)
                    )
                )
            count++;
        }
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
                        bind.header.topViewImage.setImageResource(R.drawable.ic_stepper_1)
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