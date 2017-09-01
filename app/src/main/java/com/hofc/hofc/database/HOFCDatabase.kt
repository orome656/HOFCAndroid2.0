package com.hofc.hofc.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.hofc.hofc.models.Actu

/**
 * Created by maladota on 01/09/2017.
 */
@Database(entities = arrayOf(Actu::class), version = 1)
abstract class HOFCDatabase: RoomDatabase() {
    abstract fun actuDao(): ActuDao
}