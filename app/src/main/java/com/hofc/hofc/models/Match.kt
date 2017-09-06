package com.hofc.hofc.models

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.hofc.hofc.enums.VoteStatut
import java.util.*

/**
 * Created by maladota on 06/09/2017.
 */
@Entity
data class Match (
        @PrimaryKey
        var id: Int,
        var equipe1: String,
        var equipe2: String,
        var score1: Int?,
        var score2: Int?,
        var date: Date,
        var idJournee: Int?,
        var infos: String,
        var voteStatut: VoteStatut,
        var message: String?,
        @Embedded(prefix = "compet_")
        var competition: Competition
)