package com.app.easyreviser.repository.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.app.easyreviser.repository.dao.CardDao
import com.app.easyreviser.repository.dao.DayDao
import com.app.easyreviser.repository.entities.CardModel
import com.app.easyreviser.repository.entities.DayModel

@TypeConverters(com.app.easyreviser.repository.TypeConverters::class)
@Database(entities = arrayOf(CardModel::class, DayModel::class), version = 2)
abstract class AppDatabase : RoomDatabase() {


    abstract fun userDao(): CardDao
    abstract fun dayDao(): DayDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "roomdb"
                ).allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }

            return INSTANCE as AppDatabase
        }
    }
}
