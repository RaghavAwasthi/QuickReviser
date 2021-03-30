package com.app.easyreviser.repository

import android.content.Context
import com.app.easyreviser.repository.db.AppDatabase
import com.app.easyreviser.repository.entities.CardModel
import com.app.easyreviser.repository.entities.DayModel

class AppRepository {

    companion object {
        private var INSTANCE: AppRepository? = null
        private lateinit var APPDATABASE: AppDatabase

        fun getInstance(context: Context): AppRepository {
            if (INSTANCE == null) {
                INSTANCE = AppRepository()
                APPDATABASE = AppDatabase.getInstance(context)
            }

            return INSTANCE as AppRepository
        }
    }

    fun addCard(card: CardModel) {
        APPDATABASE.cardDao().insertAll(card)
        addDayCards(card)
    }

    fun addDayCards(card: CardModel) {
        var count = 0;
        var arrayofdayCodes = arrayListOf<String>("Su", "Mo", "Tu", "We", "Th", "Fr", "Sa")
        for (i in card.repeatFrequency) {
            if (i == 1)
                APPDATABASE.dayDao().insertAll(
                    DayModel(
                        job = card,
                        code = arrayofdayCodes.get(count)
                    )
                )
            count++;
        }
    }

    fun clearALL() {
        APPDATABASE.dayDao().deleteAll()
    }


}