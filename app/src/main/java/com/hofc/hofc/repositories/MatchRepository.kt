package com.hofc.hofc.repositories

import android.arch.lifecycle.LiveData
import com.hofc.hofc.HOFCApplication
import com.hofc.hofc.adapters.JsonDateAdapter
import com.hofc.hofc.database.HOFCDatabase
import com.hofc.hofc.database.MatchDao
import com.hofc.hofc.models.Match
import com.hofc.hofc.services.IRestService
import com.squareup.moshi.Moshi
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * Created by maladota on 06/09/2017.
 */
class MatchRepository: BaseRepository {

    private var matchDao: MatchDao

    constructor(): super() {
        matchDao = HOFCDatabase.getInstance(HOFCApplication.application!!.applicationContext).matchDao()
    }

    fun getMatchsForSeasonAndTeam(season: String, team: String): LiveData<List<Match>> {
        refreshMatchs()

        return matchDao.getByTeam(season, team)
    }

    private fun refreshMatchs() {
        var executor = ThreadPoolExecutor(5,10, 5000, TimeUnit.MILLISECONDS, LinkedBlockingQueue<Runnable>())
        executor.execute({
            restService?.getMatchs()
                    ?.subscribeOn(Schedulers.io())
                    ?.subscribe({
                        t ->  matchDao?.bulkSave(t)
                    })
        })
    }

}