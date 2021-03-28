package com.app.easyreviser.repository

import androidx.room.TypeConverter
import com.app.easyreviser.repository.entities.CardModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


import java.lang.reflect.Type


class TypeConverters {
    @TypeConverter
    fun fromString(value: String): ArrayList<Int> {
        val listType: Type = object : TypeToken<ArrayList<Int>>() {}.getType()
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: ArrayList<Int>): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromInputString(value: String): CardModel {
        val listType: Type = object : TypeToken<CardModel>() {}.getType()
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromCArdModel(list: CardModel): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}