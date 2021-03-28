package com.app.easyreviser.repository.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.app.easyreviser.repository.entities.DayModel

@Dao
interface DayDao {
    @Query("SELECT * FROM day_table")
    fun getAll(): List<DayModel>

    @Insert
    fun insertAll(vararg users: DayModel)

    @Delete
    fun delete(user: DayModel)
}