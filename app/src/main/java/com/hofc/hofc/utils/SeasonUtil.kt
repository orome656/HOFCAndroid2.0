package com.hofc.hofc.utils

import java.util.*

/**
 * Created by maladota on 06/09/2017.
 */
class SeasonUtil {
    companion object {
        fun getCurrentSeasonIndex(): String {
            val year = Calendar.getInstance().get(Calendar.YEAR)

            var builder = StringBuilder();
            builder.append(year)
            builder.append("/")
            builder.append(year + 1)

            return builder.toString()
        }
    }
}