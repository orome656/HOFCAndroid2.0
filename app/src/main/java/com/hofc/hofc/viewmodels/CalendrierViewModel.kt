package com.hofc.hofc.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.support.design.widget.TabLayout
import com.hofc.hofc.database.MatchDao
import com.hofc.hofc.models.Match
import com.hofc.hofc.repositories.MatchRepository
import com.hofc.hofc.utils.Constantes
import com.hofc.hofc.utils.SeasonUtil

/**
 * Created by maladota on 06/09/2017.
 */
class CalendrierViewModel: ViewModel{

    private var matchRepository: MatchRepository? = null

    val teams = MutableLiveData<List<String>>()
    val selectedTeam = MutableLiveData<String>()
    val matchs = Transformations.switchMap(selectedTeam, {team -> matchRepository?.getMatchsForSeasonAndTeam(SeasonUtil.getCurrentSeasonIndex(), team)})

    constructor(): super() {
        matchRepository = MatchRepository()
    }

    fun getTeams() {
        //return matchRepository.getTeamsForSeason(SeasonUtil.getCurrentSeasonIndex())
        this.teams.value = Constantes.TEAM_LIST
    }

    fun getMatchsForTeam(team: String) {
        this.selectedTeam?.value = team
    }
}