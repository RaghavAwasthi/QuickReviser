package com.app.easyreviser.repository

import android.content.Context
import androidx.room.Room
import com.app.easyreviser.repository.db.AppDatabase
import com.app.easyreviser.repository.entities.CardModel

class AppRepository {

    companion object {
        private var INSTANCE: AppRepository? = null
        fun getInstance(context: Context): AppRepository {
            if (INSTANCE == null) {
                INSTANCE = AppRepository()
            }

            return INSTANCE as AppRepository
        }
    }
    
    fun addCard( card: CardModel)
    {
        var count=0;
        var arrayofdayCodes= arrayListOf<String>("Su","Mo","Tu","We","Th","Fr","Sa")
        for(i in card.repeatFrequency)
        {

            count++;
        }
    }
}