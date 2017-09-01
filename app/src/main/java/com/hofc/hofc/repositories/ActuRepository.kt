package com.hofc.hofc.repositories

import android.arch.lifecycle.LiveData
import com.hofc.hofc.database.ActuDao
import com.hofc.hofc.models.Actu
import com.hofc.hofc.services.IRestService
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executor
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by maladota on 31/08/2017.
 */
@Singleton
class ActuRepository @Inject constructor(val actuDao: ActuDao, val restService: IRestService, val executor: Executor) {
    fun getActus(): LiveData<List<Actu>> {
        refreshActus();

        return actuDao.load()
    }

    private fun refreshActus() {
        executor.execute({
            restService.getActus()
                    .subscribeOn(Schedulers.io())
                    .subscribe({
                        t ->  {
                            actuDao.bulkSave(t)
                        }
                    })
        })
    }
}