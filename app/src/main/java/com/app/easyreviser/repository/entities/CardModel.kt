package com.app.easyreviser.repository.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.app.easyreviser.repository.TypeConverters
import java.io.Serializable

@Entity(tableName = "card_table")
data class CardModel(
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,
        var textFront: String = "",
        var textBack: String = "",
        var timestamp: Long = 0,
        var shortdesctiption: String = "",

        var repeatFrequency: ArrayList<Int> = ArrayList(),
        var priority: Int = 0
) : Serializable
