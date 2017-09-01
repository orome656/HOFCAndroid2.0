package com.hofc.hofc.services

import com.hofc.hofc.models.Actu
import io.reactivex.Flowable
import io.reactivex.Observable;
import retrofit2.http.GET

/**
 * Created by maladota on 30/08/2017.
 */
interface IRestService {
    @GET("actus")
    fun getActus(): Flowable<List<Actu>>
}