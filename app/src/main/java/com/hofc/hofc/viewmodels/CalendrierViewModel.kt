package com.hofc.hofc.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
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

    val teams = MutableLiveData<List<String>>();
    private val TEAM_LIST = arrayListOf<String>("equipe1", "equipe2", "equipe3")

    constructor(): super() {
        matchRepository = MatchRepository()
    }

    fun getTeams() {
        //return matchRepository.getTeamsForSeason(SeasonUtil.getCurrentSeasonIndex())
        this.teams.value = this.TEAM_LIST
    }

    fun getMatchsForTeam(team: String): LiveData<List<Match>> {
        return matchRepository.getMatchsForSeasonAndTeam(SeasonUtil.getCurrentSeasonIndex(), team)
    }
}