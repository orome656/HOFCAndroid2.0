package com.hofc.hofc.database.converters

import android.arch.persistence.room.TypeConverter
import java.util.*


/**
 * Created by maladota on 05/09/2017.
 */
class DateConverter {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.getTime()
    }
}