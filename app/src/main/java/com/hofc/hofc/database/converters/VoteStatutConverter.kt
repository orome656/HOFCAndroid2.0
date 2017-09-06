package com.hofc.hofc.database.converters

import android.arch.persistence.room.TypeConverter
import com.hofc.hofc.enums.VoteStatut

/**
 * Created by maladota on 06/09/2017.
 */
class VoteStatutConverter {
    @TypeConverter
    fun fromString(value: String?): VoteStatut? {
        return if (value == null) null else VoteStatut.valueOf(value)
    }
    @TypeConverter
    fun voteStatutToString(value: VoteStatut?): String? {
        return value?.value.toString()
    }
}