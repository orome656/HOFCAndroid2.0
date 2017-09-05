package com.hofc.hofc.repositories

import android.arch.core.util.Function
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import com.hofc.hofc.HOFCApplication
import com.hofc.hofc.database.ActuDao
import com.hofc.hofc.database.HOFCDatabase
import com.hofc.hofc.models.Actu
import com.hofc.hofc.services.IRestService
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by maladota on 31/08/2017.
 */
@Singleton
class ActuRepository {
    private var actuDao: ActuDao? = null
    private var restService: IRestService? = null

    constructor() {
        actuDao = HOFCDatabase.getInstance(HOFCApplication.application!!.applicationContext).actuDao()
        restService = Retrofit.Builder().baseUrl("https://www.webhofc.fr/api/").build().create(IRestService::class.java)
    }

    fun getActus(): LiveData<List<Actu>> {

        return actuDao!!.load()
    }

    private fun refreshActus() {
        var executor = ThreadPoolExecutor(5,10, 5000, TimeUnit.MILLISECONDS, LinkedBlockingQueue<Runnable>())
        executor.execute({
            restService?.getActus()
                    ?.subscribeOn(Schedulers.io())
                    ?.subscribe({
                        t ->  {
                            actuDao?.bulkSave(t)
                        }
                    })
        })
    }
}