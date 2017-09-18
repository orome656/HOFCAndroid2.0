package com.hofc.hofc.adapters

import com.hofc.hofc.enums.VoteStatut
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter

/**
 * Created by Anthony on 18/09/2017.
 */
class VoteStatutAdapter: JsonAdapter<VoteStatut>() {
    override fun fromJson(reader: JsonReader): VoteStatut {
        val statut = reader.nextInt()
        return VoteStatut.values()[statut]
    }

    override fun toJson(writer: JsonWriter, value: VoteStatut) {
        writer.value(value.toString())
    }
}