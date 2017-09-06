package com.hofc.hofc.repositories

import android.arch.lifecycle.LiveData
import com.hofc.hofc.HOFCApplication
import com.hofc.hofc.database.HOFCDatabase
import com.hofc.hofc.database.MatchDao
import com.hofc.hofc.models.Match

/**
 * Created by maladota on 06/09/2017.
 */
class MatchRepository {

    private var matchDao: MatchDao

    constructor() {
        matchDao = HOFCDatabase.getInstance(HOFCApplication.application!!.applicationContext).matchDao()
    }

    fun getTeamsForSeason(season: String): LiveData<List<String>> {
        return matchDao.getTeamsForSeason(season)
    }

    fun getMatchsForSeasonAndTeam(season: String, team: String): LiveData<List<Match>> {
        return matchDao.getByTeam(season, team)
    }

}