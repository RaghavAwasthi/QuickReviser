package com.app.easyreviser.repository.dao

import androidx.room.*
import com.app.easyreviser.repository.entities.DayModel

@Dao
interface DayDao {
    @Query("SELECT * FROM day_table")
    fun getAll(): List<DayModel>

    @Query("SELECT * FROM day_table WHERE code=:daycode ")
    fun getDayWise(daycode: String): List<DayModel>

    @Insert
    fun insertAll(vararg users: DayModel)

    @Delete
    fun delete(card: DayModel)

    @Update
    fun markCardasDone(card: DayModel)

    @Query(" SELECT COUNT(*) FROM day_table WHERE code=:daycode  ")
    fun getAllCountDayWise(daycode: String): Int

    @Query(" SELECT COUNT(*) FROM day_table WHERE code=:daycode AND flag=:flag")
    fun getCompletedCountDayWise(daycode: String, flag: Boolean = false): Int
}