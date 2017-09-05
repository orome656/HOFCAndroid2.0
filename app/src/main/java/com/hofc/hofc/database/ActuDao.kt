package com.hofc.hofc.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.hofc.hofc.models.Actu
import io.reactivex.Flowable

/**
 * Created by maladota on 01/09/2017.
 */
@Dao
interface ActuDao {
    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    fun save(actu: Actu)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkSave(actus: List<Actu>)

    @Query("SELECT * FROM actu")
    fun load(): LiveData<List<Actu>>
}