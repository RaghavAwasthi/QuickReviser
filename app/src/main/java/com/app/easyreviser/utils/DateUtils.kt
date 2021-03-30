package com.app.easyreviser.utils

import android.util.Log
import org.threeten.bp.DayOfWeek
import org.threeten.bp.Instant
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneId
import org.threeten.bp.zone.ZoneRulesException

object DateUtils {

    fun getCurrentDateTime(): Long {
        return Instant.now().toEpochMilli()
    }

    fun getLocalDateTime(datetime: Long): LocalDateTime {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(datetime), ZoneId.systemDefault())
    }


    fun getDateTime(date: Long): String? {
        var mdate = ""
        try {
            val dateTime: LocalDateTime = getLocalDateTime(date)
            mdate = dateTime.getMonth()
                    .toString() + " " + dateTime.getDayOfMonth() + "," + dateTime.getYear() + " " + dateTime.getHour() + ":" + dateTime.getMinute()
        } catch (e: ZoneRulesException) {
            Log.d("TAG", "getDateTime: $e")
        }
        return mdate
    }

    fun getDayCode(): String {
        var code = "Su";
        when (getLocalDateTime(Instant.now().toEpochMilli()).getDayOfWeek()) {
            DayOfWeek.SUNDAY -> code = "Su"
            DayOfWeek.MONDAY -> code = "Mo"
            DayOfWeek.TUESDAY -> code = "We"
            DayOfWeek.THURSDAY -> code = "Th"
            DayOfWeek.FRIDAY -> code = "Fr"
            DayOfWeek.SATURDAY -> code = "Sa"
        }
        return code;
    }

}