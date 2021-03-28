package com.app.easyreviser.repository.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "day_table")
data class DayModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var job: CardModel = CardModel(),
    var flag: Boolean = false,
    var code: String="Su"
)
