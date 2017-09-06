package com.hofc.hofc.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.hofc.hofc.models.Match

/**
 * Created by maladota on 06/09/2017.
 */
@Dao
interface MatchDao {
    @Insert
    fun bulkSave(matchs: List<Match>)

    @Query("SELECT * FROM match where compet_nom = :team and compet_saison = :season")
    fun getByTeam(season: String, team: String): LiveData<List<Match>>

    @Query("SELECT DISTINCT compet_nom from match where compet_saison = :season")
    fun getTeamsForSeason(season: String): LiveData<List<String>>
}