package com.hofc.hofc.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.hofc.hofc.models.Actu
import com.hofc.hofc.repositories.ActuRepository
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by maladota on 31/08/2017.
 */
class ActusListViewModel @Inject constructor(val actuRepository: ActuRepository): ViewModel() {
    private var actus: LiveData<List<Actu>>? = null
    fun getActus(): LiveData<List<Actu>>? {
        if(actus == null)
            actus = actuRepository.getActus()
        return actus
    }
}