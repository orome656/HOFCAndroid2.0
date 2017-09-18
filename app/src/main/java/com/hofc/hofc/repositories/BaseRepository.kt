package com.hofc.hofc.repositories

import com.hofc.hofc.adapters.JsonDateAdapter
import com.hofc.hofc.adapters.JsonDateTSAdapter
import com.hofc.hofc.adapters.VoteStatutAdapter
import com.hofc.hofc.enums.VoteStatut
import com.hofc.hofc.services.IRestService
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*

/**
 * Created by Anthony on 18/09/2017.
 */
abstract class BaseRepository {
    var restService: IRestService? = null
    constructor() {
        var moshi = Moshi.Builder().add(Date::class.java, JsonDateTSAdapter())
                                   .add(VoteStatut::class.java, VoteStatutAdapter()).build()
        restService = Retrofit.Builder()
                .baseUrl("https://www.webhofc.fr/api/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
                .create(IRestService::class.java)

    }
}