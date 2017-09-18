package com.hofc.hofc.adapters

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by maladota on 05/09/2017.
 */
class JsonDateTSAdapter : JsonAdapter<Date>() {
    companion object {
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    }
    @Synchronized
    @Throws(IOException::class)
    override fun fromJson(reader: JsonReader): Date {
        val string = reader.nextString()
        return sdf.parse(string)
    }

    @Synchronized
    @Throws(IOException::class)
    override fun toJson(writer: JsonWriter, value: Date) {
        val string = sdf.format(value)
        writer.value(string)
    }
}