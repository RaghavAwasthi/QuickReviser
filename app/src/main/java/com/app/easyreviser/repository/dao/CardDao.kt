package com.app.easyreviser.repository.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.app.easyreviser.repository.entities.CardModel

@Dao
interface CardDao {
    @Query("SELECT * FROM card_table")
    fun getAll(): List<CardModel>

    @Insert
    fun insertAll(vararg users: CardModel)

    @Delete
    fun delete(user: CardModel)
}
