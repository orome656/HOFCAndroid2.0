package com.hofc.hofc.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

/**
 * Created by Anthony on 29/08/2017.
 */
@Entity
data class Actu (
    @PrimaryKey
    val postId: Int,
    val titre: String,
    val texte: String,
    val url: String,
    val image: String,
    val date: Date
)