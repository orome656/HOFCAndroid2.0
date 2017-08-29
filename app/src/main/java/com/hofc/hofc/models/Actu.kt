package com.hofc.hofc.models

import java.util.*

/**
 * Created by Anthony on 29/08/2017.
 */
data class Actu (
    val postId: Int,
    val titre: String,
    val texte: String,
    val url: String,
    val image: String,
    val date: Date
)