package com.app.easyreviser.repository.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "day_table")
data class DayModel(
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,
        var job: CardModel = CardModel(),
        @ColumnInfo(name = "flag")
        var flag: Boolean = false,
        @ColumnInfo(name = "code")
        var code: String = "Su"
) : Serializable
