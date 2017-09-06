package com.hofc.hofc.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Anthony on 29/08/2017.
 */
@Entity
data class Actu (
    @PrimaryKey
    val postid: Int,
    val titre: String,
    val texte: String,
    val url: String,
    val image: String,
    val date: Date
) {
    fun formattedDate(): String {
        return SimpleDateFormat("dd/MM/yyyy").format(date)
    }
}