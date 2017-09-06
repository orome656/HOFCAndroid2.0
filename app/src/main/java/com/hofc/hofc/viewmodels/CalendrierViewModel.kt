package com.hofc.hofc.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.hofc.hofc.database.MatchDao
import com.hofc.hofc.models.Match
import com.hofc.hofc.repositories.MatchRepository
import com.hofc.hofc.utils.SeasonUtil

/**
 * Created by maladota on 06/09/2017.
 */
class CalendrierViewModel: ViewModel{

    private var matchRepository: MatchRepository

    constructor(): super() {
        matchRepository = MatchRepository()
    }

    fun getTeams(): LiveData<List<String>> {
        return matchRepository.getTeamsForSeason(SeasonUtil.getCurrentSeasonIndex())
    }

    fun getMatchsForTeam(team: String): LiveData<List<Match>> {
        return matchRepository.getMatchsForSeasonAndTeam(SeasonUtil.getCurrentSeasonIndex(), team)
    }
}